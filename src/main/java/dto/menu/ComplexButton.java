package dto.menu;

public class ComplexButton extends Button {

	public ComplexButton(String name, Button[] subButton) {
		super(name);
		this.subButton = subButton;
	}

	private Button[] subButton;

	public Button[] getSubButton() {
		return subButton;
	}

	public void setSubButton(Button[] subButton) {
		this.subButton = subButton;
	}
}
