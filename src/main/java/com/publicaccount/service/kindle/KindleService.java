package com.publicaccount.service.kindle;

/***
 * 检索并且推送文档至kindle
 *
 */
public interface KindleService {
	
	boolean searchAndPush(String emailAddress, String fileName);

}
