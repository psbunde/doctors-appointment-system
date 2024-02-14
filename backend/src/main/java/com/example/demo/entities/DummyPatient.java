package com.example.demo.entities;

import java.sql.Date;

import lombok.Data;

@Data
public class DummyPatient {

	String fname,lname,email,password,contact_no,gender,answer,area,city,state,blood_group,diabetes,blood_pressure;
	
	int role_id,question_id,pincode;
	
	Date birthdate;

}
