package UI;

public class MenuItem {

	private String title;
	private IAction action;
	private Menu nextMenu;
	
	
	public MenuItem() {
		
	}
	
	public IAction getAction() {
		return action;
	}

	public void setAction(IAction action) {
		this.action = action;
	}

	public MenuItem(String title, IAction action, Menu nextMenu) {
		this.title = title;
		this.action = action;
		this.nextMenu = nextMenu;
	}
	
	public void setNextMenu(Menu nextMenu) {
		this.nextMenu = nextMenu;
	}
	
	public Menu getNextMenu() {
		return nextMenu;
	}

	public String getTitle() {
		return title;
	}

	public void doAction() {
		action.execute();
	}

}
