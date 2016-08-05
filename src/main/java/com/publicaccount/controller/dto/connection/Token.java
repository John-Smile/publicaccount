package com.publicaccount.controller.dto.connection;

public class Token {
	private String accessToken;
	private int expiresInSeconds;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresInSeconds() {
		return expiresInSeconds;
	}
	public void setExpiresInSeconds(int expiresInSeconds) {
		this.expiresInSeconds = expiresInSeconds;
	}
}
