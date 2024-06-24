package com.tbttest.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbttest.demo.business.ClientBusiness;
import com.tbttest.demo.dto.BasicResponse;
import com.tbttest.demo.entity.Client;
import com.tbttest.demo.exceptions.ClientDbException;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {
	
	@Autowired
	private ClientBusiness clientBusiness;
	
	@GetMapping
	public List<Client> readAll() {

		return StreamSupport.stream(clientBusiness.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value = "id") String id) {
		Optional<Client> oClient = clientBusiness.findById(id);

		if (!oClient.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oClient.get());

	}

	@PostMapping
	public ResponseEntity<?> registerClient(@RequestBody Client client) {

		try {
			return ResponseEntity.ok(clientBusiness.registerClient(client));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BasicResponse(e.getMessage()));
		}
	}

	@PutMapping
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {
		try {
			return ResponseEntity.ok(clientBusiness.registerClient(client));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicResponse> deleteClientById(@PathVariable(value = "id") String id) {

		try {
			return ResponseEntity.ok(clientBusiness.deleteClient(id));
		} catch (ClientDbException e) {
			return ResponseEntity.internalServerError().body(new BasicResponse(e.getMessage()));
		}
	}
	
	

}
