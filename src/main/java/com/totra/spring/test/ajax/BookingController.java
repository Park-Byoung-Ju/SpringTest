package com.totra.spring.test.ajax;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.totra.spring.test.ajax.domain.Booking;
import com.totra.spring.test.ajax.service.BookingService;

@RequestMapping("/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping("/list")
	public String getAllList(Model model){
		List<Booking> bookingList = new ArrayList<>();
		bookingList = bookingService.getAllList();
		
		model.addAttribute("bookingList", bookingList);
		return "ajax/bookingList"; 
	}
	
	@RequestMapping("/input")
	public String input() {
		
		return "ajax/bookingInput";
	}
	
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> create(@RequestParam("name") String name
						,@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
						,@RequestParam("day") int day
						,@RequestParam("headcount") int headcount
						,@RequestParam("phoneNumber") String phoneNumber) {
		
		boolean isTrue = bookingService.setCreateBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, String> result = new HashMap<>();
		
		if(isTrue == true) {			
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		
		return result;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, Boolean> idByDelete(@RequestParam("id") int id){
		
		Map<String, Boolean> result = new HashMap<>();
		
		boolean isTrue = bookingService.idByDelete(id);
		
		result.put("result", isTrue);
		
		return result;
	}
	
	@RequestMapping("/main")
	public String mainPage() {
		return "ajax/bookingSearch";
	}
	
	
	// Boolean
	@ResponseBody
	@GetMapping("/bookingSearch")
	public Map<String, Booking> getBookingInfo(@RequestParam("name") String name
											,@RequestParam("phoneNumber") String phoneNumber
											,@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
		
		
		
		Booking booking = bookingService.getBookingInfo(name, phoneNumber, date);
		
		Map<String, Booking> result = new HashMap<>();
		
		result.put("result", booking);

		
		return result;
	}
}
