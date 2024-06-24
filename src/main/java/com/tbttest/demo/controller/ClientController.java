package com.tbttest.demo.controller;

import java.util.List;
import java.util.Optional;
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
import com.tbttest.demo.exceptions.ClientNotFoundException;
import com.tbttest.demo.utils.Messages;
import com.tbttest.demo.utils.Utils;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {
	
	@Autowired
	private ClientBusiness clientBusiness;
	
	@GetMapping
	public List<Client> readAll() {

		return StreamSupport.stream(clientBusiness.findAll().spliterator(), false).toList();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getClientById(@PathVariable(value = "id") String id) {
		Optional<Client> oClient;
		
		try {
			oClient = clientBusiness.findById(id);
			if (!oClient.isPresent()) {
				return ResponseEntity.badRequest().build();
			}

			return ResponseEntity.ok(oClient.get());
		} catch (ClientNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		} catch (ClientDbException e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}

		

	}

	@PostMapping
	public ResponseEntity<?> registerClient(@RequestBody Client client) {

		try {
			if(Optional.ofNullable(client).filter(c->!Utils.isEmpty(c.getDocumentId())&&
					!Utils.isEmpty(c.getName()) && !Utils.isEmpty(c.getPhone())).isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BasicResponse(Messages.BODY_ERROR));
			}
			
			return ResponseEntity.ok(clientBusiness.registerClient(client));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BasicResponse(e.getMessage()));
		}
	}

	@PutMapping
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {
		try {
			
			if(!Optional.ofNullable(client).filter(c->!Utils.isEmpty(c.getDocumentId()) &&
					!Utils.isEmpty(c.getName()) &&
					!Utils.isEmpty(c.getPhone())).isPresent()) {
				return ResponseEntity.badRequest().build();
			}
			
			clientBusiness.findById(client.getDocumentId());
			
			return ResponseEntity.ok(clientBusiness.registerClient(client));
		} catch (ClientNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteClientById(@PathVariable(value = "id") String id) {

		try {
			clientBusiness.findById(id);
			return ResponseEntity.ok(clientBusiness.deleteClient(id));
		} catch (ClientNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BasicResponse("Cliente no encontrado"));
		} catch (ClientDbException e) {
			return ResponseEntity.internalServerError().body(new BasicResponse(e.getMessage()));
		}
	}
	
	

}
