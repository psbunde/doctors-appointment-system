package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int user_id;
	
	@Column
	String fname,lname,email,password,gender,answer;
	
	@Column
	String contact_no;
	
	@OneToOne
	@JoinColumn(name="address_id")
	Address address_id;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	Role role_id;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	Questions question_id;

	public User(String fname, String lname, String email, String password, String contact_no, String gender,
			String answer, Address address_id, Role role_id, Questions question_id) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.contact_no = contact_no;
		this.gender = gender;
		this.answer = answer;
		this.address_id = address_id;
		this.role_id = role_id;
		this.question_id = question_id;
	}
}
