package com.tbttest.demo.business;

import java.util.Optional;

import com.tbttest.demo.dto.BasicResponse;
import com.tbttest.demo.entity.Client;
import com.tbttest.demo.exceptions.ClientDbException;


public interface ClientBusiness {
	
	public Iterable<Client> findAll();
	
	public Optional<Client> findById(String documentId);
	
	public Client registerClient(Client client);
	
	public Client updateClient(Client client);
	
	public BasicResponse deleteClient(String documentId) throws ClientDbException;
}
