package com.tractorental.fullstack_backend;

import com.tractorental.fullstack_backend.entity.Farmer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class FullstackBackendApplicationTests {

	@Autowired
	private FarmerService service;

	@Test
	void contextLoads() {
	}

	@Test
	void testSaveFarmerDetails()
	{
		Farmer farmer = new Farmer();
		farmer.setName("Varad");
		farmer.setAge(21);
		farmer.setContact("8605256138");
		farmer.setEmail("varad848@gmail.com");
		farmer.setAddress("Arali Khurd, Tuljapur, Dharashiv");
		farmer.setCropsGrown("Wheat, Jowar, Tur, Moong, Bengal Gram");
		farmer.setLandArea(2.89);
		farmer.setRegistrationDate(LocalDateTime.now());
		farmer.setAadharNumber("898955755172");
		farmer.setPaymentDue(5000.00);

		Assertions.assertNotNull(service.saveFarmerDetails(farmer));
	}
}
