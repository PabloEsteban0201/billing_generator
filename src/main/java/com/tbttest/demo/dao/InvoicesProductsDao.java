package com.tbttest.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tbttest.demo.entity.InvoiceProductKey;
import com.tbttest.demo.entity.InvoicesProducts;
import com.tbttest.demo.entity.Product;

public interface InvoicesProductsDao extends JpaRepository<InvoicesProducts, InvoiceProductKey> {

	public List<InvoicesProducts> findByInvoice_InvoiceId(Long invoiceId);

	@Query("SELECT p FROM Product p JOIN InvoicesProducts ip ON p.id = ip.product.id WHERE ip.invoice.id = :invoiceId")
	List<Product> findProductsByInvoiceId(@Param("invoiceId") Long invoiceId);

}
