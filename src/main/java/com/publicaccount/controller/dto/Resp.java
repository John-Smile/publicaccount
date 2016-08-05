package com.publicaccount.controller.dto;

public class Resp {
	private String code;
	private String msg;
	private Object data;
	
	public Resp(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public static final Resp SUCCESS = new Resp(Code.SUCCESS.value, Msg.SUCCESS.value);
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public enum Code {
		SUCCESS("0"),
		FAIL("1");
		
		private String value;
		
		private Code(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	public enum Msg {
		SUCCESS("成功"),
		FAIL("失败");
		
		private String value;
		
		private Msg(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}

}
