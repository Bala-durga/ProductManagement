package com.cts.pm.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull(message="address can not be nulll")
	private String line1;
    private String line2;
    
    @NotNull(message="city can not be null")
    private String city;
    
    @NotNull(message="state can not be null")
    private String state;
    
    @NotNull(message="pincode can not be nul")
    @Size(message="pincode must be of 6 digits")
	private String pincode;

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
