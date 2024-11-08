package com.totra.spring.test.mvc.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.totra.spring.test.mvc.test02.domain.Realtor;
import com.totra.spring.test.mvc.test02.service.RealtorService;

@RequestMapping("/mvc/test02")
@Controller
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;

	@RequestMapping("/input")
	public String redirectInput() {
		return "mvc/realtorinput";
	}
	
	@PostMapping("/insert")
	public String addRealtor(
			@RequestParam("office") String office
			,@RequestParam("phoneNumber") String phoneNumber
			,@RequestParam("address") String address
			,@RequestParam("grade") String grade
			,Model model) {
		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		int count = realtorService.insertRealtorByObject(realtor);
		
		model.addAttribute("realtor", realtor);
		
		return "mvc/realtorlist";
	}
}
