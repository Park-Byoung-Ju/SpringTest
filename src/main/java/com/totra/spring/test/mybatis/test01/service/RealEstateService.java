package com.totra.spring.test.mybatis.test01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totra.spring.test.mybatis.test01.domain.RealEstate;
import com.totra.spring.test.mybatis.test01.repository.RealEstateRepository;

@Service
public class RealEstateService {
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public RealEstate getIdRealEstate(int id) {
		RealEstate realEstate = realEstateRepository.getIdSelect(id);
		
		return realEstate;
	}
	
	
	 public List<RealEstate> getRentRealEstate(int rent){ 
		 List<RealEstate> realEstateList = realEstateRepository.getRentPriceSelect(rent); 
		 return realEstateList; 
	 }
	 
	 public List<RealEstate> getTwoParamRealEstate(int area, int price){
		 List<RealEstate> realEstateList = realEstateRepository.getTwoParamSelect(area, price);
		 
		 return realEstateList;
	 }
	 
}
