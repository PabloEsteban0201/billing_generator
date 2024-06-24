package com.tbttest.demo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbttest.demo.dao.ProductDao;
import com.tbttest.demo.dto.BasicResponse;
import com.tbttest.demo.entity.Product;
import com.tbttest.demo.exceptions.ProductDbException;
import com.tbttest.demo.exceptions.ProductDbNotFoundException;

@Service
public class ProductBusinessImpl implements ProductBusiness {

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional(readOnly=true)
	public List<Product> findAll() {

		return productDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Product findById(Long productId) throws ProductDbNotFoundException {

		Optional<Product> oProduct = productDao.findById(productId);
		if (!oProduct.isPresent()) {
			throw new ProductDbNotFoundException("Producto no encontrado");
		}

		return oProduct.get();
	}

	@Override
	@Transactional(rollbackFor = ProductDbException.class)
	public Product registerProduct(Product product) throws ProductDbException {

		try {
			return productDao.save(product);

		} catch (Exception e) {
			throw new ProductDbException("Error no controlado: " + e.getMessage());
		}

	}

	@Override
	@Transactional(rollbackFor = ProductDbException.class)
	public Product updateProduct(Product product) throws ProductDbException {

		try {

			return productDao.save(product);

		} catch (Exception e) {
			throw new ProductDbException("Error no controlado: " + e.getMessage());
		}

	}

	@Override
	@Transactional(rollbackFor = ProductDbException.class)
	public BasicResponse deleteProductById(Long productId) throws ProductDbException {
		try {
			productDao.deleteById(productId);
			return new BasicResponse("Producto eliminado exitosamente");
		} catch (Exception e) {
			throw new ProductDbException("Error no controlado: " + e.getMessage());
		}
	}

}
