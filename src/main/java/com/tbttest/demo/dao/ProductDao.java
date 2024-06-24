package com.tbttest.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbttest.demo.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
