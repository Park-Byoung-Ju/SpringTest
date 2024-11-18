package com.totra.spring.test.ajax.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totra.spring.test.ajax.domain.Booking;
import com.totra.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getAllList(){
		List<Booking> bookingList = bookingRepository.getBookingAllList();
		
		return bookingList;
	}
	
	public boolean setCreateBooking(String name
			,Date date
			,int day
			,int headcount
			,String phoneNumber) {
		
		int count = bookingRepository.setCreateBooking(name, date, day, headcount, phoneNumber);
		
		return count>0;
	}
	
	public boolean idByDelete(int id) {
		
		int count = bookingRepository.idByDelete(id);
		
		return count>0;
	}
	
	public Booking getBookingInfo(String name, String phoneNumber,Date date) {
		
		Booking booking = bookingRepository.getBookingInfo(name, phoneNumber, date);
		
		return booking;
	}
}
