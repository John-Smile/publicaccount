package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import dto.menu.Menu;

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
		}
	}

}
