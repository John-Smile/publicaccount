package com.publicaccount.utils;

import java.awt.Menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class MenuUtil {
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);
	
	public final static String MENU_CREATE_URL = CommonUtil.CGI_URL + "/menu/create"
			+ CommonUtil.QUESTION_MARK + CommonUtil.PARAM_TOKEN;
	public final static String MENU_GET_URL = CommonUtil.CGI_URL + "/menu/get"
			+ CommonUtil.QUESTION_MARK + CommonUtil.PARAM_TOKEN;
	public final static String MENU_DELETE_URL= CommonUtil.CGI_URL + "/menu/delete"
			+ CommonUtil.QUESTION_MARK + CommonUtil.PARAM_TOKEN;
	
	public static boolean createMenu(Menu menu, String accessToken) {
		boolean result = false;
		String url = MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		String jsonMenu = JSONObject.toJSONString(menu);
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);
		
		if (null != jsonObject) {
			int errorCode = jsonObject.getIntValue("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (errorCode == 0) {
				result = true;
			} else {
				result = false;
				log.error("创建菜单失败 errorCode:{} errMsg:{}", errorCode, errorMsg);
			}
		}
		return result;
	}
	
	public static String getMenu(String accessToken) {
		String result = null;
		String requestUrl = MENU_GET_URL.replace(CommonUtil.ACCESS_TOKEN, accessToken);
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, CommonUtil.METHOD_GET, null);
		
		if (null != jsonObject) {
			result = jsonObject.toString();
		}
		return result;
	}
	
	public static boolean deleteMenu(String accessToken) {
		boolean result = false;
		String requestUrl = MENU_DELETE_URL.replace(CommonUtil.ACCESS_TOKEN, accessToken);
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, CommonUtil.METHOD_GET, null);
		
		if (null != jsonObject) {
			int errorCode = jsonObject.getIntValue(CommonUtil.RESP_CODE);
			String errorMsg = jsonObject.getString(CommonUtil.RESP_MSG);
			if (0 == errorCode) {
				result = true;
			} else {
				result = false;
				log.error("删除菜单失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return result;
	}

}
