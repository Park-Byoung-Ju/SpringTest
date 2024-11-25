package com.totra.spring.test.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.totra.spring.test.jpa.domain.Recruit;
import com.totra.spring.test.jpa.repository.RecruitRepository;

@RequestMapping("/jpa/native")
@Controller
public class RecruitController {

	@Autowired
	public RecruitRepository recruitRepository;	
	
	@ResponseBody
	@RequestMapping("/id")
	public Recruit findById() {
		int id = 8;
		Optional<Recruit> optionalRecruit = recruitRepository.findById(id);
		Recruit recruit = optionalRecruit.orElse(null);
		
		return recruit;
	}
	
	@ResponseBody
	@RequestMapping("/companyId")
	public List<Recruit> findByCompanyId(@RequestParam("companyId") int companyId){
		
		return recruitRepository.findByCompanyId(companyId);
	}
	
	@ResponseBody
	@RequestMapping("/double")
	public List<Recruit> findByTypeAndPosition(){
	
		return recruitRepository.findByTypeAndPosition("정규직", "웹 back-end 개발자");
	}
	
	@ResponseBody
	@RequestMapping("/or")
	public List<Recruit> findByTypeOrSalaryGreaterThan(){
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	@ResponseBody
	@RequestMapping("/order")
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(){
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	@ResponseBody
	@GetMapping("/between")
	public List<Recruit> findByRegionAndBySalaryBetween(){
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	@ResponseBody
	@RequestMapping("/native")
	public List<Recruit> findByNative(){
		LocalDate localDate = LocalDate.of(2026, 4, 10);
		return recruitRepository.findByNative(localDate, 8100, "정규직");
	}
}
