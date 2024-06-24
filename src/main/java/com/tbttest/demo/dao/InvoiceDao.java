package com.tbttest.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbttest.demo.entity.Invoice;

public interface InvoiceDao extends JpaRepository<Invoice, Long> {

}
