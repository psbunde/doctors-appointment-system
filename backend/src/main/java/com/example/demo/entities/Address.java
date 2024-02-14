package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="address")
@Data
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	int address_id;
	
	@Column
	String area,city,state;
	
	@Column
	int pincode;

	public Address(String area, String city, String state, int pincode) {
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
}
