package com.tbttest.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
	
	@Id
	@Column(name = "documentid", nullable = false)
	private String documentId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "phone", nullable = false, length = 11)
	private String phone;
	
	@JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices = new ArrayList<>();

	public Client(String documentId, String name, String phone, List<Invoice> invoices) {
		super();
		this.documentId = documentId;
		this.name = name;
		this.phone = phone;
		this.invoices = invoices;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	
	

}
