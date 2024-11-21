package com.totra.spring.test.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totra.spring.test.jpa.domain.Company;
import com.totra.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> companyCreate(List<Company> companyList){
		List<Company> resultList = companyRepository.saveAll(companyList);

		return resultList;
	}
	
	public Company updateCompany(int id) {
		Optional<Company> optionalBubblePang = companyRepository.findById(id);
		Company bubblePang = optionalBubblePang.orElse(null);
		
		
		bubblePang = bubblePang.toBuilder()
								.scale("중소기업")
								.headcount(34)
								.build();

		Company result = companyRepository.save(bubblePang);
		
		return result;
	}
	
	public String deleteCompany(int id) {
		
		Optional<Company> optionalBubblePang = companyRepository.findById(id);
		
		Company bubblePang = optionalBubblePang.orElse(null);
		
		if(bubblePang != null) {
			companyRepository.delete(bubblePang);
			return "Entity로 삭제!";
		}else {
			companyRepository.deleteById(id);
			return "id로 삭제!";
		}
	}
}
