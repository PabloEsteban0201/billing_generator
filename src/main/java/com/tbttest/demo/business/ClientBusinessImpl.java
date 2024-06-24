package com.tbttest.demo.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbttest.demo.dao.ClientDao;
import com.tbttest.demo.dto.BasicResponse;
import com.tbttest.demo.entity.Client;
import com.tbttest.demo.exceptions.ClientDbException;

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

	@Override
	@Transactional
	public Client registerClient(Client client) {
		
		return clientDao.save(client);
	}

	@Override
	@Transactional
	public Client updateClient(Client client) {
		
		return clientDao.save(client);
	}

	@Override
	@Transactional(rollbackFor = ClientDbException.class)
	public BasicResponse deleteClient(String documentId) throws ClientDbException {
		
		try {
			clientDao.deleteById(documentId);
			return new BasicResponse("Cliente eliminado exitosamente");
		} catch (Exception e) {
			throw new ClientDbException("Error al borrar el client");
		}
	}


}
