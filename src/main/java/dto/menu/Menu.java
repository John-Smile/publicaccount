package dto.menu;

public class Menu {
	
	public Menu(Button[] buttons) {
		super();
		this.buttons = buttons;
	}

	private Button[] buttons;

	public Button[] getButtons() {
		return buttons;
	}

	public void setButtons(Button[] buttons) {
		this.buttons = buttons;
	}
}
