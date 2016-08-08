package com.publicaccount.service.kindle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.publicaccount.service.kindle.KindleService;
import com.publicaccount.service.push.PushService;
import com.publicaccount.service.push.dto.PushCarrier;
import com.publicaccount.service.search.SearchService;
import com.publicaccount.service.search.dto.BookDTO;

@Service
public class KindleServiceImpl implements KindleService {
	@Resource
	private SearchService searchService;
	@Resource
	private PushService pushService;

	@Override
	public boolean searchAndPush(String emailAddress, String fileName) {
		if (searchService.searchFile(fileName)) {
			BookDTO book = searchService.getFile(fileName);
			pushService.push(new PushCarrier(new String[]{emailAddress}, book));
			return true;
		} else {
			return false;
		}
	}
}
