package com.tbttest.demo.business;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tbttest.demo.dto.BasicResponse;
import com.tbttest.demo.dto.InvoiceDto;
import com.tbttest.demo.entity.Invoice;
import com.tbttest.demo.exceptions.BasicException;
import com.tbttest.demo.exceptions.InvoiceDbException;

@Service
public interface InvoiceBusiness {
	
	public Invoice registerInvoice(InvoiceDto invoice) throws InvoiceDbException;
	
	public Iterable<Invoice> findAll();
	
	public Optional<Invoice> findById(Long invoiceId);
	
	public Invoice updateInvoice(InvoiceDto invoiceDto) throws BasicException;
	
	public BasicResponse deleteInvoice(Long invoiceId) throws InvoiceDbException;

}
