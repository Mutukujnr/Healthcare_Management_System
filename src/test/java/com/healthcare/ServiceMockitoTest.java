package com.healthcare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.healthcare.models.Patient;
import com.healthcare.repositories.PatientRepository;
import com.healthcare.services.IPatient;
import com.healthcare.services.PatientService;

@SpringBootTest(classes = {ServiceMockitoTest.class})
public class ServiceMockitoTest {

	@Mock
	PatientRepository patientRepository;
	
	@InjectMocks
	PatientService patientService;
	
	
	List<Patient> patients;
	
	@Test
	@Order(1)
	public void test_getAllPatients() {
		
	 patients = new ArrayList<Patient>();
	 patients.add(new Patient("Alice","alice@gmail.com","072344567",null,null));
	 patients.add(new Patient("John","john@gmail.com","072347867",null,null));
	 
		when(patientRepository.findAll()).thenReturn(patients);
		assertEquals(2, patientService.allPatients());
	}
}
