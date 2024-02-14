package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.DummyPatient;
import com.example.demo.entities.Patient;
import com.example.demo.services.PatientService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Transactional
public class PatientController {
	
	@Autowired
	PatientService pservice;
	
	@PostMapping("/registerPatient")
	public Patient register(@RequestBody DummyPatient patient)
	{
		return pservice.register(patient);
	}
	
	
	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients()
	{
		return pservice.getAllPatients();
	}

	@GetMapping("/getPatientByUId")
	public Patient getPatientByUId(@RequestParam("user_id")int user_id)
	{
		return pservice.getPatientByUId(user_id);
	}
	@GetMapping("/getPatientByPId")
	public Patient getPatientByPId(@RequestParam("patient_id")int patient_id)
	{
		return pservice.getPatientByPId(patient_id);
	}
	
}
