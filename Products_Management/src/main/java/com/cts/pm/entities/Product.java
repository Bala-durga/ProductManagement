package com.cts.pm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(description="this is the product model")
@Entity(name="products")
public class Product {
	
	@ApiModelProperty(value="A unique key for each product")
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int productId;
	
	@ApiModelProperty(value="name of the product")
	@NotNull(message ="product name can not be null")
	@Size(min=3,max=30,message="product name must be equal or greater than 3 and less than 30")
	@Column(name="name")
	private String productName;
	
	@ApiModelProperty(value="description of the product")
	@NotNull(message="product description can not be null")
	@Column(name="description")
	private String productDescription;
	
	@NotNull(message="product price can not be null")
//	@Pattern(regexp="[\\s]*[0-9][1-9]+",message="price can not be negative")
	@Column
	private float price;
	
	@ManyToOne
	private Vendor vendor;
	

	public Product() {
		super();
	}

	public Product(int productId, String productName, String productDescription, float price, Vendor vendor) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.vendor = vendor;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", price=" + price + ", vendor=" + vendor + "]";
	}
	
	
}
