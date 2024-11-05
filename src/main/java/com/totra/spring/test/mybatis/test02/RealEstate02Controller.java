package com.totra.spring.test.mybatis.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.totra.spring.test.mybatis.test02.domain.RealEstate;
import com.totra.spring.test.mybatis.test02.service.RealEstate02Service;

@RequestMapping("/mybatis/test02")
@Controller
// 이름 변경
public class RealEstate02Controller {

	@Autowired
	private RealEstate02Service realEstate02Service;
	
	@RequestMapping("/1")
	@ResponseBody
	public String addRealEstate() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count =  realEstate02Service.insertByObject(realEstate);
		
		return "입력 성공 : " + count;
	}
	
	
	@RequestMapping("/2")
	@ResponseBody
	public String addRealEstateNotObject(@RequestParam("realtorId") int realtorId) {
		String address ="썅떼빌리버 오피스텔 814호";
		int area = 45;
		String type = "월세";
		int price = 100000;
		int rentPrice = 120;
		
		int count = realEstate02Service.insertByParam(realtorId, address, area, type, price, rentPrice);
		
		return "입력 성공: " + count;
	}
	
	@RequestMapping("/update/1")
	@ResponseBody
	public String updateRealEstate() {
		int id = 22;
		String type = "전세";
		int price = 70000;
		int count = realEstate02Service.updateRealEstate(id, type, price);
		
		return "입력 성공 : " + count;
	}
	
	@RequestMapping("/delete/1")
	@ResponseBody
	public String deleteRealEstate() {
		int id = 22;
		int count = realEstate02Service.deleteRealEstate(id);
		
		return "삭제 성공: " + count;
	}
	
	
	
}
