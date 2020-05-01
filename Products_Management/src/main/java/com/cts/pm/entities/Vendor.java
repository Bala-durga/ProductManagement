package com.cts.pm.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name="vendors")
public class Vendor {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@NotNull(message="name can not be null")
	@Size(min=3,message="name must be greater than 3 characters")
	private String name;
	@Embedded
	
	@NotNull(message="address can not be null")
	private Address address;
	
	@Pattern(regexp="^((\\+){1}91){1}[1-9]{1}[0-9]{9}$",message="must +91 be added while giving ph number")
	private String phone;
	
	@NotNull(message="email id can not be null")
	@Email
	private String emailId;
	
	public Vendor() {
		super();
	}
	public Vendor(int id, String name, Address address, String phone, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.emailId = emailId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", emailId="
				+ emailId + "]";
	}
	
	
}
