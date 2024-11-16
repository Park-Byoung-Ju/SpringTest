package com.totra.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totra.spring.test.ajax.domain.Bookmark;
import com.totra.spring.test.ajax.repository.BookmarkRepository;

@Service
public class BookmarkService {
	@Autowired
	private BookmarkRepository bookmarkRepository;

	public int bookmarkCreate(String name, String url) {
		int count = bookmarkRepository.bookmarkInsert(name, url);
		return count;
	}
	
	public List<Bookmark> allData(){
		List<Bookmark> allDataList = bookmarkRepository.allData();
		return allDataList;
	}
	
	public int urlCheck(String url) {
		int count = bookmarkRepository.urlCheck(url);
		return count;
	}
	
	public int idDelete(int id) {
		
		int count = bookmarkRepository.idDelete(id);
		
		return count;
	}
}
