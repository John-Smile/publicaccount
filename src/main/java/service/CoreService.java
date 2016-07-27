package service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.message.response.TextMessage;
import util.MessageUtil;

public class CoreService {

	public static String processRequest(HttpServletRequest request) {
		String respXML = null;
		String respContent = "未知的消息类型！";
		
		try {
		    Map<String, String> requestMap = MessageUtil.parseXML(request);	
		    String fromUserName = requestMap.get("FromUser");
		    String toUserName = requestMap.get("ToUserName");
		    String msgType = requestMap.get("MsgType");
		    
		    TextMessage textMessage = new TextMessage();
		    textMessage.setToUserName(fromUserName);
		    textMessage.setFromUserName(toUserName);
		    textMessage.setCreateTime(new Date().getTime());
		    textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		    
		    if (msgType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
		    	respContent = "您发送的是文本消息！";
		    } else if (msgType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
		    	respContent = "您发送的是图片消息！";
		    } else if (msgType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
		    	respContent = "您发送的是语音消息！";
		    } else if (msgType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_VEDIO)) {
		    	respContent = "您发送的是视频消息！";
		    } else if (msgType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
		    	respContent = "您发送的是地理位置消息！";
		    } else if (msgType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
		    	respContent = "您发送的是链接消息！";
		    } else if (msgType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
		    	String eventType = requestMap.get("Event");
		    	if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
		    		respContent = "谢谢您的关注！";
		    	} else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
		    		// TODO
		    	} else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
		    		// TODO
		    	} else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_SCAN)) {
		    		respContent = "您扫描了二维码！";
		    	} else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_SCAN)) {
		    		respContent = "您扫描了二维码！";
		    	} else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_LOCATION)) {
		    		respContent = "您上报了地理位置！";
		    	} else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_CLICK)) {
		    		respContent = "您点击了菜单！";
		    	}
		    }
		    textMessage.setContent(respContent);
		    respXML = MessageUtil.messageToXML(textMessage);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return respXML;
	}

}
