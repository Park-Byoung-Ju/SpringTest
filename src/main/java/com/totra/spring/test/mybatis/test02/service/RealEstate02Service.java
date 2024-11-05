package com.totra.spring.test.mybatis.test02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totra.spring.test.mybatis.test02.domain.RealEstate;
import com.totra.spring.test.mybatis.test02.repository.RealEstate02Repository;

@Service
public class RealEstate02Service {
	
	@Autowired
	private RealEstate02Repository repository;
	
	public int insertByObject(RealEstate realEstate) {
		int count = repository.insertRealEstate(realEstate);
		return count;
	}

	public int insertByParam(int realtorId
							, String address
							, int area
							, String type
							, int price
							, int rentPrice) {
		
		int count = repository.insertRealEstate(realtorId, address, area, type, price, rentPrice);
		
		return count;
		
	}
	
	public int updateRealEstate(int id, String type, int price) {
		// 기존의 정보를 가져와서
		RealEstate realEstate = repository.updateSelectRealEstate(id);
		// 수정값을 넣은뒤
		realEstate.setType(type);
		realEstate.setPrice(price);
		// 수정된 값으로 수정하는 것을 생각했으나 문제에서 type price만 바꾸는것을 고려하지않고
		// 어떠한 값을 변경하더라도 바뀌는 것을 생각하고 만들었으나 query문은 type price만 변경
		int count = repository.updateRealEstate(realEstate);
		return count;
	}
	
	public int deleteRealEstate(int id) {
		int count = repository.deleteRealEstate(id);
		return count;
	}
}
