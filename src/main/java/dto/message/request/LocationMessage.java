package dto.message.request;

public class LocationMessage extends BaseMessage {
	private String locationX;
	private String locatinY;
	private String scale;
	private String label;
	
	public String getLocationX() {
		return locationX;
	}
	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}
	public String getLocatinY() {
		return locatinY;
	}
	public void setLocatinY(String locatinY) {
		this.locatinY = locatinY;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
