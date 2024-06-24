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
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
