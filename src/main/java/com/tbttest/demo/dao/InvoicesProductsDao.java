package com.tbttest.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbttest.demo.entity.InvoiceProductKey;
import com.tbttest.demo.entity.InvoicesProducts;

public interface InvoicesProductsDao extends JpaRepository<InvoicesProducts, InvoiceProductKey> {
	
	public List<InvoicesProducts> findByInvoice_InvoiceId(Long invoiceId);
	
}
