package com.tbttest.demo.business;

import java.util.List;

import com.tbttest.demo.dto.BasicResponse;
import com.tbttest.demo.entity.Product;
import com.tbttest.demo.exceptions.ProductDbException;
import com.tbttest.demo.exceptions.ProductDbNotFoundException;

public interface ProductBusiness {
	
	public List<Product> findAll();
	
	public Product findById(Long productId) throws ProductDbNotFoundException;
	
	public Product registerProduct(Product product) throws ProductDbException;
	
	public Product updateProduct(Product product) throws ProductDbException;
	
	public BasicResponse deleteProductById(Long productId) throws ProductDbException;

}
