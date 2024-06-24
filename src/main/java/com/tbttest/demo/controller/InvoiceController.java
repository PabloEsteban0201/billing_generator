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

import com.tbttest.demo.business.InvoiceBusiness;
import com.tbttest.demo.dto.BasicResponse;
import com.tbttest.demo.dto.InvoiceDto;
import com.tbttest.demo.entity.Invoice;
import com.tbttest.demo.exceptions.ClientNotFoundException;
import com.tbttest.demo.exceptions.InvoiceDbException;
import com.tbttest.demo.exceptions.InvoiceNotFoundException;

@RestController
@RequestMapping("/invoice")
@CrossOrigin(origins = "*")
public class InvoiceController {
	
	@Autowired
	private InvoiceBusiness invoiceBusiness;
	
	@PostMapping
	public ResponseEntity<?> createInvoice(@RequestBody InvoiceDto invoiceDto){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(invoiceBusiness.registerInvoice(invoiceDto));
		} catch (InvoiceDbException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
	
	@GetMapping
	public List<Invoice> readAll() {

		return StreamSupport.stream(invoiceBusiness.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable(value = "id") Long id) {
		Optional<Invoice> oInvoice = invoiceBusiness.findById(id);

		if (!oInvoice.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oInvoice.get());

	}


	@PutMapping
	public ResponseEntity<?> updateInvoice(@RequestBody InvoiceDto invoiceDto) {
		try {
			return ResponseEntity.ok(invoiceBusiness.updateInvoice(invoiceDto));
		} catch (InvoiceNotFoundException | ClientNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicResponse> deleteInvoiceById(@PathVariable(value = "id") Long id) {

		try {
			return ResponseEntity.ok(invoiceBusiness.deleteInvoice(id));
		} catch (InvoiceDbException e) {
			return ResponseEntity.internalServerError().body(new BasicResponse(e.getMessage()));
		}
	}
	
	

}
