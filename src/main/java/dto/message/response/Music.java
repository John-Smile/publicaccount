package dto.message.response;

public class Music {
	private String title;
	private String description;
	private String mucisUrl;
	private String hqMusicUrl;
	private String thumbMediaId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMucisUrl() {
		return mucisUrl;
	}
	public void setMucisUrl(String mucisUrl) {
		this.mucisUrl = mucisUrl;
	}
	public String getHqMusicUrl() {
		return hqMusicUrl;
	}
	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
}
