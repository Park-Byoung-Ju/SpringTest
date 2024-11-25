package com.totra.spring.test.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.totra.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {
	
	public List<Recruit> findByCompanyId(int companyId);
	
	public List<Recruit> findByTypeAndPosition(String type, String position);

	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);

	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);

	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);

	@Query(value="SELECT * FROM `recruit` WHERE `deadline` > :deadline AND `salary` >= :salary AND `type`=:type ", nativeQuery=true)
	public List<Recruit> findByNative(@Param("deadline") LocalDate deadline
									,@Param("salary") int salary
									,@Param("type") String type);
}