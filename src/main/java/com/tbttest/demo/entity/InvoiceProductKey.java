package com.tbttest.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class InvoiceProductKey implements Serializable {
	
	private static final long serialVersionUID = 8648503111276778965L;
	
	private Long invoice;
    private Long product; 
    
	public InvoiceProductKey() {
		super();
	}

	public InvoiceProductKey(Long invoiceId, Long productId) {
		super();
		this.invoice = invoiceId;
		this.product = productId;
	}

	public Long getInvoiceId() {
		return invoice;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoice = invoiceId;
	}

	public Long getProductId() {
		return product;
	}

	public void setProductId(Long productId) {
		this.product = productId;
	}
    
    

}
