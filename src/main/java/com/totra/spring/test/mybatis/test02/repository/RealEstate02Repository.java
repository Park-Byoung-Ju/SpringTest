package com.totra.spring.test.mybatis.test02.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.totra.spring.test.mybatis.test02.domain.RealEstate;

@Mapper
public interface RealEstate02Repository {

	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstate(@Param("realtorId") int realtorId
							,@Param("address") String address
							,@Param("area") int area
							,@Param("type") String type
							,@Param("price") int price
							,@Param("rentPrice") int rentPrice);
	
	public RealEstate updateSelectRealEstate(@Param("id") int id);
	
	public int updateRealEstate(RealEstate realEstate);
	
	public int deleteRealEstate(@Param("id") int id);
}
