package com.cts.pm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pm.entities.Product;
import com.cts.pm.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("http://localhost:4200")
@RestController


@Api(value="The product Controller", description="Rest controller for product")
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@ApiOperation(value="Get all products",
			produces="A list of products",
			notes="Hit this URL to get all product details")
	
	@RequestMapping("/all")
	List<Product> getAll() {
		return service.getProducts();
	}
    
	
	@ApiOperation(value="Retrieve a product's details",
			produces="A product's details if it exists",
			notes="Hit this URL to get a product's details")
	
	@RequestMapping("/{productId}")
	Product getById(@PathVariable Integer productId) {
		return service.getProductById(productId);
	}
	
	@ApiOperation(value="Add a product",
			consumes="A new Product is JSON",
			notes="Hit this URL to insert a new Products's details")

	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	void addProduct(@Valid @RequestBody Product product) {
		service.addProduct(product);
	}
    
	@ApiOperation(value="Update a product's details",
			consumes="An existing product in JSON",
			notes="Hit this URL to update a product's details")
	
	@RequestMapping(method = RequestMethod.PUT)
	void updateProduct(@Valid @RequestBody Product product) {
		service.updateProduct(product);
	}
	
	
	@ApiOperation(value="Retrieve a product's details",
			produces="A product's details if it exists",
			notes="Hit this URL to get a product's details")
	
	@RequestMapping("/{productName")
	List<Product> getProductsByName(@PathVariable String productName){
		return service.getProductsByName(productName);
	}
	
	
	@ApiOperation(value="Delete a product",
			consumes="An existing product id",
			notes="Hit this URL to delete a product's details")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{productId}")
	void deleteProductById(@PathVariable Integer productId) {
		service.deleteProduct(productId);
	}

}
