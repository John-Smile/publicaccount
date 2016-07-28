package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import dto.menu.Menu;

public class MenuUtil {
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);
	
	public final static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/"
			+ "menu/create?access_token=ACCESS_TOKEN";
	public final static String MENU_GET_URL = "https://api.weinxin.qq.com/cgi-bin/menu"
			+ "/get?access_token=ACCESS_TOKEN";
	public final static String MENU_DELETE_URL= "https://api.weixin.qq.com/cgi-bin/menu"
			+ "/delete?access_token=ACCESS_TOKEN";
	
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
