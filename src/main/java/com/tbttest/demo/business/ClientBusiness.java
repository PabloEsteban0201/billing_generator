package com.tbttest.demo.business;

import java.util.Optional;

import com.tbttest.demo.dto.BasicResponse;
import com.tbttest.demo.entity.Client;
import com.tbttest.demo.exceptions.ClientDbException;
import com.tbttest.demo.exceptions.ClientNotFoundException;


public interface ClientBusiness {
	
	public Iterable<Client> findAll();
	
	public Optional<Client> findById(String documentId) throws ClientDbException, ClientNotFoundException;
	
	public Client registerClient(Client client) throws ClientDbException;
	
	public Client updateClient(Client client) throws ClientDbException, ClientNotFoundException;
	
	public BasicResponse deleteClient(String documentId) throws ClientDbException;
}
