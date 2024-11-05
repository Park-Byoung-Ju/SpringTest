package com.totra.spring.test.mybatis.test01.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.totra.spring.test.mybatis.test01.domain.RealEstate;

@Mapper
public interface RealEstateRepository {

	public RealEstate getIdSelect(@Param("id") int id);
	
	public List<RealEstate> getRentPriceSelect(@Param("rentPrice") int rent);
	
	public List<RealEstate> getTwoParamSelect(@Param("area") int area, 
											  @Param("price") int price);
}
