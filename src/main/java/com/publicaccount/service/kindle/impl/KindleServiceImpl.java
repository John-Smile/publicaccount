package com.publicaccount.service.kindle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.publicaccount.service.kindle.KindleService;
import com.publicaccount.service.push.PushService;
import com.publicaccount.service.search.SearchService;

@Service
public class KindleServiceImpl implements KindleService {
	@Resource
	private SearchService searchService;
	@Resource
	private PushService pushService;

	@Override
	public boolean searchAndPush(String emailAddress, String fileName) {
		if (searchService.searchFile(fileName)) {
			byte[] file = searchService.getFile(fileName);
			pushService.push(new String[]{emailAddress}, fileName, file);
			return true;
		} else {
			return false;
		}
	}

}
