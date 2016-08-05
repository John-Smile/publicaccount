package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.CommonUtil;
import util.MenuUtil;
import dto.connection.Token;
import dto.menu.Button;
import dto.menu.ClickButton;
import dto.menu.ComplexButton;
import dto.menu.Menu;
import dto.menu.ViewButton;

public class MenuManager {
	private static  Logger log = LoggerFactory.getLogger(MenuManager.class);
	
	private static Menu getMenu() {
		ClickButton btn11 = new ClickButton("开源中国", "click", "oschina");
		ClickButton btn12 = new ClickButton("ITeye", "click", "iteye");
		ViewButton btn13 = new ViewButton("CocoaChina", "view", "http://www.iteye.com");
		
		ViewButton btn21 = new ViewButton("淘宝", "view", "http://m.taobao.com");
		ViewButton btn22 = new ViewButton("京东", "view", "http://m.jd.com");
		ViewButton btn23 = new ViewButton("唯品会", "view", "http://m.vipshop.com");
		ViewButton btn24 = new ViewButton("当当", "view", "http://m.dangdang.com");
		ViewButton btn25 = new ViewButton("苏宁易购", "view", "http://m.suning.com");
		
		ViewButton btn31 = new ViewButton("多泡", "view", "http://m.duopao.com");
		ViewButton btn32 = new ViewButton("一窝88", "view", "http://m.yi588.com");
		
		ComplexButton mainBtn1 = new ComplexButton("技术交流", new Button[]{btn11, btn12, btn13});
		ComplexButton mainBtn2 = new ComplexButton("购物", new Button[]{btn21, btn22, btn23, btn24, btn25});
		ComplexButton mainBtn3 = new ComplexButton("网页游戏", new Button[]{btn31, btn32});
		
		Menu menu = new Menu(new Button[]{mainBtn1, mainBtn2, mainBtn3});
		return menu;
	}
	
	public static void main(String[] args) {
		String appId = "";
		String appSecret = "";
		Token token = CommonUtil.getToken(appId, appSecret);
		
		if (null != token) {
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
			if (result) {
				log.info("菜单创建成功!");
			} else {
				log.info("菜单创建失败");
			}
		}
	}

}
