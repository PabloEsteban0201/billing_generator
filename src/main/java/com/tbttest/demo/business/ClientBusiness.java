package com.tbttest.demo.business;

import java.util.Optional;

import com.tbttest.demo.entity.Client;


public interface ClientBusiness {
	
	public Iterable<Client> findAll();
	
	public Optional<Client> findById(String documentId);
}
