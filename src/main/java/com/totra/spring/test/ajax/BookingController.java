package com.totra.spring.test.ajax;

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
	
	// 언제, 어디서, 무엇을, 어떻게, 왜
	// 언제 : 사용자가 예약정보를 입력하고 저장을 수행하고자 할때
	// 어디서 : 서버
	// input (request) : 예약에 필요한 예약자 정보
	// 기능 : 
	// 무엇을 : 예약 정보를 저장한다.
	// 어떻게 : 예약정보를 booking 테이블에 insert 한다
	// 왜 : 테이블에 저장해야 나중에 예약 목록을 얻어 올 수 있으니까
	// output (response) : 저장 결과
	// 성공 : {"result","success"} 
	// 실패 : {"result", "fail"}
	
	@ResponseBody
	@PostMapping("/create")
	public Map<String, Boolean> create(@RequestParam("name") String name
						,@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
						,@RequestParam("day") int day
						,@RequestParam("headcount") int headcount
						,@RequestParam("phoneNumber") String phoneNumber) {
		
		boolean isTrue = bookingService.setCreateBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(isTrue) {			
			result.put("result", isTrue);
		}else {
			result.put("result", isTrue);
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
	
	
	// 언제 : 사용자가 이름과 전화번호를 입력하고 조회를 요청했을때
	// 어디서 : 서버에서
	// input : 예약자 이름, 전화 번호
	// 기능 : 
	// 무엇을 : 이름과 전화번호가 일치하는 사용자 정보 조회
	// 어떻게 : booking 테이블에 이름과 전화번호를 조건으로 일치하는 행 조회
	// 왜 : 예약자의 모든 정보가 필요하니가
	// output : 예약자 정보
	
	
	// Boolean
	@ResponseBody
	@GetMapping("/bookingSearch")
	public Map<String, Object> getBookingInfo(@RequestParam("name") String name
											,@RequestParam("phoneNumber") String phoneNumber
											,@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
		
		
		
		Booking booking = bookingService.getBookingInfo(name, phoneNumber, date);
		
		Map<String, Object> result = new HashMap<>();
		
		if(booking != null) {
			result.put("isTrue", true);
			
		}else {
			result.put("isTrue", false);
		}
		
		result.put("result", booking);

		
		return result;
	}
}
