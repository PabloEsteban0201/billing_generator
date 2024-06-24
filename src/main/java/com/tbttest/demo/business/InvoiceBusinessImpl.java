package com.tbttest.demo.business;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbttest.demo.dao.ClientDao;
import com.tbttest.demo.dao.InvoiceDao;
import com.tbttest.demo.dao.InvoicesProductsDao;
import com.tbttest.demo.dao.ProductDao;
import com.tbttest.demo.dto.BasicResponse;
import com.tbttest.demo.dto.InvoiceDto;
import com.tbttest.demo.entity.Client;
import com.tbttest.demo.entity.Invoice;
import com.tbttest.demo.entity.InvoicesProducts;
import com.tbttest.demo.entity.Product;
import com.tbttest.demo.exceptions.BasicException;
import com.tbttest.demo.exceptions.ClientNotFoundException;
import com.tbttest.demo.exceptions.InvoiceDbException;
import com.tbttest.demo.exceptions.InvoiceNotFoundException;

@Service
public class InvoiceBusinessImpl implements InvoiceBusiness {
	
	@Autowired
	private InvoiceDao invoiceDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private InvoicesProductsDao invoiceProductsDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Invoice registerInvoice(InvoiceDto invoiceDto) throws InvoiceDbException {
		
		try {
			
			Set<Product> products = invoiceDto.getProductIds().stream().map(id -> productDao.findById(id))
					.filter(Optional::isPresent).map(Optional::get).collect(Collectors.toSet());
			
			Optional<Client> client = clientDao.findById(invoiceDto.getClientId());
			
			if(!client.isPresent()) {
				throw new ClientNotFoundException("Cliente no encontrado documento:" + invoiceDto.getClientId());
			}
			
			Invoice invoice = new Invoice(null, calculateTotalAmount(products), invoiceDto.getDateInvoice(), client.get());
			
			Invoice invoiceDb = invoiceDao.save(invoice);
			
			if(!products.isEmpty()) {
				products.forEach(product->invoiceProductsDao.save(new InvoicesProducts(invoiceDb, product)));
			}
			

			return invoiceDb;
			
		} catch (Exception e) {
			throw new InvoiceDbException("Error al guadar factura", e);
		}
		
	}
	
	private BigDecimal calculateTotalAmount(Set<Product> products) {
		
		if(products.isEmpty()) {
			return BigDecimal.ZERO;
		}
		
		return products.stream().filter(Objects::nonNull).map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
		
	}

	@Override
	public Iterable<Invoice> findAll() {
	
		return invoiceDao.findAll();
	}

	@Override
	public Optional<Invoice> findById(Long invoiceId) {
		
		return invoiceDao.findById(invoiceId);
	}

	@Override
	public Invoice updateInvoice(InvoiceDto invoiceDto) throws BasicException {

		try {

			Set<Product> products = invoiceDto.getProductIds().stream().map(id -> productDao.findById(id))
					.filter(Optional::isPresent).map(Optional::get).collect(Collectors.toSet());

			Optional <Client> client = clientDao.findById(invoiceDto.getClientId());
			
			if(!client.isPresent()) {
				throw new ClientNotFoundException("Cliente no encontrado documento:" + invoiceDto.getClientId());
			}
			
			Optional <Invoice> invoice = invoiceDao.findById(invoiceDto.getInvoiceId());
			
			if(!invoice.isPresent()) {
				throw new InvoiceNotFoundException("Factura no encontrada id:" + invoiceDto.getInvoiceId());
			}
			
			Invoice invoiceUpdate = invoice.get();
			
			invoiceUpdate.setClient(client.get());
			invoiceUpdate.setDateInvoice(invoiceDto.getDateInvoice());
			invoiceUpdate.setTotalAmount(calculateTotalAmount(products));

			Invoice invoiceDb = invoiceDao.save(invoiceUpdate);

			if(products.isEmpty()) {
				products.forEach(product -> invoiceProductsDao.delete(new InvoicesProducts(invoiceUpdate, product)));
			}else {
				products.forEach(product -> invoiceProductsDao.save(new InvoicesProducts(invoiceUpdate, product)));
			}
			
			return invoiceDb;

		} catch (BasicException e) {
			throw e;
		}catch (Exception e) {
			throw new InvoiceDbException("Error al guadar factura", e);
		}
	}

	@Override
	@Transactional(rollbackFor = InvoiceDbException.class)
	public BasicResponse deleteInvoice(Long invoiceId) throws InvoiceDbException {
		try {
			invoiceDao.deleteById(invoiceId);
			return new BasicResponse("Factura eliminada exitosamente");
		} catch (Exception e) {
			throw new InvoiceDbException("Error al borrar factura");
		}
	}

}
