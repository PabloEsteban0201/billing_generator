package com.tbttest.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbttest.demo.business.ClientBusiness;
import com.tbttest.demo.entity.Client;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {
	
	@Autowired
	private ClientBusiness clientBusiness;
	
	@GetMapping
	public List<Client> readAll(){
		
		List<Client> employees = StreamSupport.
				stream(clientBusiness.findAll().spliterator(), false).
				collect(Collectors.toList());
		
		return employees;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value="id")String id){
		Optional<Client> oClient = clientBusiness.findById(id);
	
		if(!oClient.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oClient.get());
		
	}
	
	

}
