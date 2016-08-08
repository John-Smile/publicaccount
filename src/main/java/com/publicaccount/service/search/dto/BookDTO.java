package com.publicaccount.service.search.dto;

import java.io.File;

public class BookDTO {
	private String bookName;
	private String contentFormt;
    private String filePath;
    
	public BookDTO(String bookName, int contentFormt, String directory) {
		super();
		this.bookName = bookName;
		this.contentFormt = ContentFormat.valueOf(contentFormt);
		this.filePath = directory + File.separator + bookName;
	}
	
	enum ContentFormat {
		PDF(1, "application/pdf");
		
		int code;
		String value;
		ContentFormat(int code, String value) {
			this.code = code;
			this.value = value;
		}
		
		public static String valueOf(int code) {
			for (ContentFormat contentFormat : values()) {
				if (code == contentFormat.getCode()) {
					return contentFormat.getValue();
				}
			}
			String msg = String.format("非法的文件格式编码:%d", code);
			throw new RuntimeException(msg);
		}

		public int getCode() {
			return code;
		}

		public String getValue() {
			return value;
		}
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getContentFormt() {
		return contentFormt;
	}
	public void setContentFormt(String contentFormt) {
		this.contentFormt = contentFormt;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
