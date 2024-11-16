package com.totra.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.totra.spring.test.ajax.domain.Bookmark;

@Mapper
public interface BookmarkRepository {
	public int bookmarkInsert(@Param("name") String name
							,@Param("url") String url);
	
	public List<Bookmark> allData();
	
	public int urlCheck(@Param("url") String url);
	
	public int idDelete(@Param("id") int id);
}
