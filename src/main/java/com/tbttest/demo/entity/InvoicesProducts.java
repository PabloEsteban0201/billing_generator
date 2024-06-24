package com.tbttest.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVOICES_PRODUCTS")
@IdClass(InvoiceProductKey.class)
public class InvoicesProducts {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICES_INVOICE_ID")
    private Invoice invoice;

	@Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTS_PRODUCT_ID")
    private Product product;

	public InvoicesProducts(Invoice invoice, Product product) {
		super();
		this.invoice = invoice;
		this.product = product;
	}

	public InvoicesProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice getTypeConcept() {
		return invoice;
	}

	public void setTypeConcept(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getPayment() {
		return product;
	}

	public void setPayment(Product product) {
		this.product = product;
	}
	
	

}
