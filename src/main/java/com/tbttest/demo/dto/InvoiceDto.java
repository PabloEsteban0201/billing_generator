package com.tbttest.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class InvoiceDto {
	
	private Long invoiceId;
	
    private BigDecimal totalAmount;

    private LocalDate dateInvoice;
    
    private List<Long> productIds;
    
    private String clientId;
    

	public InvoiceDto() {
	}

	public InvoiceDto(Long invoiceId, BigDecimal totalAmount, LocalDate dateInvoice, List<Long> productIds, String clientId) {
		super();
		this.totalAmount = totalAmount;
		this.dateInvoice = dateInvoice;
		this.productIds = productIds;
		this.clientId = clientId;
		this.invoiceId =invoiceId;
	}
	
	
	public InvoiceDto(BigDecimal totalAmount, LocalDate dateInvoice, List<Long> productIds, String clientId) {
		super();
		this.totalAmount = totalAmount;
		this.dateInvoice = dateInvoice;
		this.productIds = productIds;
		this.clientId = clientId;
	}

	public InvoiceDto(LocalDate dateInvoice, List<Long> productIds, String clientId) {
		super();
		this.dateInvoice = dateInvoice;
		this.productIds = productIds;
		this.clientId = clientId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getDateInvoice() {
		return dateInvoice;
	}

	public void setDateInvoice(LocalDate dateInvoice) {
		this.dateInvoice = dateInvoice;
	}

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	

}
