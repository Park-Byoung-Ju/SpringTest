package com.totra.spring.test.mvc.test02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totra.spring.test.mvc.test02.domain.Realtor;
import com.totra.spring.test.mvc.test02.repository.RealtorRepository;

@Service
public class RealtorService {

	@Autowired
	private RealtorRepository realtorRepository;
	
	public int insertRealtorByObject(Realtor realtor) {
		int count = realtorRepository.insertRealtorByObject(realtor);
		return count;
	}
}
