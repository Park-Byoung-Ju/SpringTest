package com.totra.spring.test.mvc.test01.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.totra.spring.test.mvc.test01.domain.Seller;

@Mapper
public interface SellerRepository {

	public int UserInsert(@Param("nickname") String nickname
						,@Param("profileImage") String profileImage
						,@Param("temperature") double temperature);
	
	public Seller LastSelectUser();
	
	public Seller userId(@Param("id") int id);
}
