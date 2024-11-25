package com.totra.spring.test.jpa.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder=true)
@Table(name="`recruit`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Recruit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="companyId")
	private int companyId;
	
	@Column(name="position")
	private String position;
	
	@Column(name="responsibilities")
	private String responsibilities;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="type")
	private String type;
	
	@Column(name="region")
	private String region;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="deadline")
	private LocalDateTime deadline;
	
	@Column(name="createdAt")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
