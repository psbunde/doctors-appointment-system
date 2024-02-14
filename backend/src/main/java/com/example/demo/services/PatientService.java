package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Address;
import com.example.demo.entities.DummyPatient;
import com.example.demo.entities.Passwordbasedencryption;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Questions;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.repositories.QuestionsRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository prepo;
	
	@Autowired
	RoleRepository rrepo;
	
	@Autowired
	QuestionsRepository qrepo;
	
	@Autowired
	UserRepository urepo;
	
	@Autowired
	AddressRepository arepo;
	
	@Value("${spring.saltvalue}")
	String salt;
	
	public Patient register(DummyPatient patient)
	{
		Role role = new Role(3,"Patient");
		Questions que = new Questions(patient.getQuestion_id());
		Address add=new Address(patient.getArea(),patient.getCity(),patient.getState(),patient.getPincode());
		arepo.save(add);
			
		String encryption=Passwordbasedencryption.generateSecurePassword(patient.getPassword(),salt);
		
		User u=new User(patient.getFname(),patient.getLname(),patient.getEmail(),encryption,patient.getContact_no(),patient.getGender(),patient.getAnswer(),add,role,que);
		urepo.save(u);
		
		Patient pt=new Patient(patient.getBirthdate(),patient.getBlood_group(),patient.getDiabetes(),patient.getBlood_pressure(),u);
		return prepo.save(pt);
	}
	
	
	public List<Patient> getAllPatients()
	{
		return prepo.findAll();
	}
	
	public Patient getPatientByUId(int user_id)
	{
		User u=urepo.findById(user_id).get();  //findById returns optional---use get method to retrieve
		
		return prepo.getPatientByUId(u);
	}
	
	public Patient getPatientByPId(int patient_id)
	{		
		return prepo.findById(patient_id).get();
	}
}
