package com.totra.spring.test.mvc.test02.repository;

import org.apache.ibatis.annotations.Mapper;

import com.totra.spring.test.mvc.test02.domain.Realtor;

@Mapper
public interface RealtorRepository {

	public int insertRealtorByObject(Realtor realtor);
}
