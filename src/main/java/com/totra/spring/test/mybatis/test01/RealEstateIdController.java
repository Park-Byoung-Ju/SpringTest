package com.totra.spring.test.mybatis.test01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.totra.spring.test.mybatis.test01.domain.RealEstate;
import com.totra.spring.test.mybatis.test01.service.RealEstateService;

@RequestMapping("/mybatis/real-estate/select")
@Controller
public class RealEstateIdController {

	@Autowired
	private RealEstateService realEstateService;

	
	@ResponseBody
	@RequestMapping("/1")
	public RealEstate getIdRealEstate(@RequestParam("id") int id) {
		RealEstate realEstate = realEstateService.getIdRealEstate(id);
		
		return realEstate;
	}	
	
	
	@ResponseBody
	@RequestMapping("/2")
	public List<RealEstate> getrentPriceRealEstate(@RequestParam("rent") int rent){ 
		List<RealEstate> realEstateList = realEstateService.getRentRealEstate(rent);
	 
		return realEstateList; 
	}
	
	@ResponseBody
	@RequestMapping("/3") // name : 파라미터 키워드, required : null을 허용하는지 여부, defaultValue : 파라미터 값이 null일때 자동으로 들어가는 값
	public List<RealEstate> getTwoParamRealEstate(@RequestParam(value="area", required=false, defaultValue="0") int area, @RequestParam(value="price", required=false, defaultValue="0") int price){
		List<RealEstate> realEstateList = realEstateService.getTwoParamRealEstate(area, price);
		
		return realEstateList;
	}
	
}
