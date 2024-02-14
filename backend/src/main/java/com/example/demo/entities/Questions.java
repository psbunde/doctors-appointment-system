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
@Table(name="questions")
@Data
@NoArgsConstructor
public class Questions {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int question_id;
	
	@Column
	String question;
	
	public Questions(int question_id) {
		this.question_id = question_id;
	}

    
}
