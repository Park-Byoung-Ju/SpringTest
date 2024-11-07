package com.totra.spring.test.mvc.test01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.totra.spring.test.mvc.test01.domain.Seller;
import com.totra.spring.test.mvc.test01.service.SellerService;


@RequestMapping("/mvc/test01")
@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;

	@PostMapping("/insert")
	public String addUserAndInfo(@RequestParam("nickname") String nickname
						 ,@RequestParam("profileImage") String profileImage
						 ,@RequestParam("temperature") double temperature
						 ) {
		
		int count = sellerService.addUserAndUserInfo(nickname, profileImage, temperature);
		
		if(count == 1) {
			return "redirect:/mvc/test01/lastinfo";
		}
		
		return "mvc/sellerinput";
	}
	
	@GetMapping("/lastinfo")
	public String userLastInfo(Model model) {
		
		Seller seller = sellerService.userLastSelect();
		
		model.addAttribute("title", "등록한 사용자 정보");
		model.addAttribute("seller", seller);
		return "mvc/sellerinfo";
	}

	@RequestMapping("/input")
	public String sellerInput() {
		
		return "mvc/sellerinput";
	}
	
	@RequestMapping("/sellersearch")
	public String sellerSearchForm() {
		
		return "mvc/sellersearch";
	}
	
	@GetMapping("/idserach")
	public String userId(@RequestParam(value="id", required=false) Integer id
			, Model model) {
		
		if(id == null) {
			return "redirect:/mvc/test01/lastinfo";
		}
		
		Seller seller = sellerService.userId(id);
		
		model.addAttribute("title", "사용자 정보");
		model.addAttribute("seller", seller);
		return "mvc/sellerinfo";
	}
}
