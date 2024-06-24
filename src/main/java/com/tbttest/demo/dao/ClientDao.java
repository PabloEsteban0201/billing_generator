package com.tbttest.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbttest.demo.entity.Client;

public interface ClientDao extends JpaRepository<Client, String> {
	

}
