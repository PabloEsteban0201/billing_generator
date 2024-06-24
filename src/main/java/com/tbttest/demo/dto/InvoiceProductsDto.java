package com.tbttest.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.tbttest.demo.entity.Product;

public class InvoiceProductsDto {

	private Long invoiceId;

	private BigDecimal totalAmount;

	private LocalDate dateInvoice;

	private List<Product> products;

	private String clientId;

	public InvoiceProductsDto(Long invoiceId, BigDecimal totalAmount, LocalDate dateInvoice, List<Product> products,
			String clientId) {
		super();
		this.invoiceId = invoiceId;
		this.totalAmount = totalAmount;
		this.dateInvoice = dateInvoice;
		this.products = products;
		this.clientId = clientId;
	}

	public InvoiceProductsDto() {
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

}
