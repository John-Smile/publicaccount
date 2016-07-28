package dto.menu;

public class ComplexButton extends Button {
	private Button[] subButton;

	public Button[] getSubButton() {
		return subButton;
	}

	public void setSubButton(Button[] subButton) {
		this.subButton = subButton;
	}
}
