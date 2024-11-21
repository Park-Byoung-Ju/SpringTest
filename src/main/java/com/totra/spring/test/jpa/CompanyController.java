package com.totra.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.totra.spring.test.jpa.domain.Company;
import com.totra.spring.test.jpa.service.CompanyService;

@RequestMapping("/jpa/company")
@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	
	@ResponseBody
	@RequestMapping("/create")
	public List<Company> CreateCompany() {
		// 정보 1
		Company nexon = Company.builder()
								.name("넥슨")
								.business("컨텐츠 게임")
								.scale("대기업")
								.headcount(3585)
								.build();
		// 정보 2
		Company bubblePang = Company.builder()
								.name("버블팡")
								.business("여신 금융업")
								.scale("대기업")
								.headcount(6834)
								.build();
		
		List<Company> companyList = new ArrayList<>();
		companyList.add(nexon);
		companyList.add(bubblePang);
		
		List<Company> resultList = companyService.companyCreate(companyList);
		
		return resultList;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Company updateCompany() {
		int id = 8;
		
		Company result = companyService.updateCompany(id);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String deleteCompany() {
		int id = 8;
		
		String result = companyService.deleteCompany(id);
		
		
		return "회사 정보 삭제!" + "\n" + result;
	}
}
