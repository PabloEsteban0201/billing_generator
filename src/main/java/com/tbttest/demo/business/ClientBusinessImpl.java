package com.tbttest.demo.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbttest.demo.dao.ClientDao;
import com.tbttest.demo.entity.Client;

@Service
public class ClientBusinessImpl implements ClientBusiness {

	@Autowired
	private ClientDao clientDao;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Client> findAll() {
		
		return clientDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<Client> findById(String documentId) {
		
		return clientDao.findById(documentId);
	}


}
