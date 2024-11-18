package com.totra.spring.test.ajax.repository;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.totra.spring.test.ajax.domain.Booking;

@Mapper
public interface BookingRepository {
	
	public List<Booking> getBookingAllList();
	
	public int setCreateBooking(@Param("name") String name
							,@Param("date") Date date
							,@Param("day") int day
							,@Param("headcount") int headcount
							,@Param("phoneNumber") String phoneNumber);
	
	public int idByDelete(@Param("id") int id);
	
	public Booking getBookingInfo(@Param("name") String name
								,@Param("phoneNumber") String phoneNumber
								,@Param("date") Date date);

}
