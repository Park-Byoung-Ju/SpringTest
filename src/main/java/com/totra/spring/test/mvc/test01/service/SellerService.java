package com.totra.spring.test.mvc.test01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totra.spring.test.mvc.test01.domain.Seller;
import com.totra.spring.test.mvc.test01.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public int addUserAndUserInfo(String nickname
									,String profileImage
									,double temperature) {
		
		int count = sellerRepository.UserInsert(nickname, profileImage, temperature);

		return count;
	}
	
	public Seller userLastSelect() {
		Seller seller = sellerRepository.LastSelectUser();
		
		return seller;
	}
	
	public Seller userId(int id) {
		Seller seller = sellerRepository.userId(id);
		
		return seller;
	}
}
