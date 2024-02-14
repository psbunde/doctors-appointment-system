package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="patients")
@Data
@NoArgsConstructor
public class Patient{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int patient_id;
	
	@Column
	Date birthdate;
	
	@Column
	String blood_group,diabetes,blood_pressure;
	
	@OneToOne
	@JoinColumn(name="user_id")
	User user_id;

	public Patient(Date birthdate, String blood_group, String diabetes, String blood_pressure, User user_id) {
		this.birthdate = birthdate;
		this.blood_group = blood_group;
		this.diabetes = diabetes;
		this.blood_pressure = blood_pressure;
		this.user_id = user_id;
	}
}
