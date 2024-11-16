package com.totra.spring.test.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.totra.spring.test.ajax.domain.Bookmark;
import com.totra.spring.test.ajax.service.BookmarkService;

@RequestMapping("/ajax/test/bookmark")
@Controller
public class BookmarkController {
	@Autowired
	private BookmarkService bookmarkService;

	@RequestMapping("/info")
	public String bookmarkInfo() {
		
		return "ajax/favoriteInfo";
	}
	
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> bookmarkCreate(@RequestParam("name") String name
						,@RequestParam("url") String url) {
		int count = bookmarkService.bookmarkCreate(name, url);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@ResponseBody
	@PostMapping("/check")
	public Map<String, Integer> urlCheck(@RequestParam("url") String url) {
		int count = bookmarkService.urlCheck(url);
		Map<String, Integer> result = new HashMap<>();
		result.put("result", count);
		
		return result;
	}
	
	@RequestMapping("/list")
	public String bookmarkAllDate(Model model) {
		
		List<Bookmark> bookmarkList = new ArrayList<>();
		
		bookmarkList = bookmarkService.allData();
		
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "ajax/favoriteList";
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> bookmarkDelete(@RequestParam("id") int id) {
		
		int count = bookmarkService.idDelete(id);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
