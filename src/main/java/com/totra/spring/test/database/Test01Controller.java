package com.totra.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.totra.spring.test.database.domain.Store;
import com.totra.spring.test.database.service.StoreService;

@Controller
public class Test01Controller {
	@Autowired
	private StoreService storeService;
	
	@ResponseBody
	@RequestMapping("/db/store/list")
	public List<Store> storeList() {
		List<Store> storeList = storeService.getStoreList();
		return storeList;
	}
}
