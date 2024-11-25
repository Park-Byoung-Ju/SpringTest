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
			companyRepository.deleteById(id);
			return "삭제 완료!";
		}else {

			return "삭제할 항목이 없다!";
		}

		/*
		if(optionalBubblePang.isPresent()) {
			// null이 아닐떄
		}else {
			// null ㅣㅇㄹ떄
		}
		*/
		
		// 람다식을 활용한 것
		// optionalCompany.ifPresent(company -> companyRepository.delete);
	}
}
