package com.tbttest.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.tbttest.demo.business.ProductBusiness;
import com.tbttest.demo.entity.Product;
import com.tbttest.demo.exceptions.ProductDbException;
import com.tbttest.demo.exceptions.ProductDbNotFoundException;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private ProductBusiness productBusiness;

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable(value = "id") Long id) {
		try {
			return ResponseEntity.ok(productBusiness.findById(id));
		} catch (ProductDbNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productBusiness.findAll());
	}

	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		try {
			if (!Optional.ofNullable(product).filter(p -> p.getName() != null && !p.getName().isEmpty()).isPresent()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}

			return ResponseEntity.status(HttpStatus.OK).body(productBusiness.registerProduct(product));
		} catch (ProductDbException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@PutMapping
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {
		try {
			if (!Optional.ofNullable(product)
					.filter(p -> p.getName() != null && !p.getName().isEmpty() && p.getProductId() != null)
					.isPresent()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}

			productBusiness.findById(product.getProductId());
			return ResponseEntity.status(HttpStatus.OK).body(productBusiness.updateProduct(product));
		} catch (ProductDbNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		} catch (ProductDbException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) {
		try {
			
			if(id==null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			
			productBusiness.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(productBusiness.deleteProductById(id));
		} catch (ProductDbNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}catch (ProductDbException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

}
