package UI;

import java.util.ArrayDeque;
import java.util.Deque;

public class Navigator {

	private final int BACK = 9999;
	private Menu currentMenu;
	private Deque<Menu> history;

	public Navigator(Menu currentMenu) {
		this.currentMenu = currentMenu;
		this.history = new ArrayDeque<Menu>();
	}
	
	public void printMenu() {
		try {
			System.out.println("**" + currentMenu.getName() + "**");
			MenuItem[] items = currentMenu.getMenuItems();
			int i = 0;
			for(MenuItem menuItem : items) {
				System.out.println(i + " -> " + menuItem.getTitle());
				i++;
			}
			System.out.println(BACK + " - BACK");
		} catch (Exception e) {
			System.out.println(currentMenu.getName() + "not exist");
		}
	}

	public boolean navigate(int index) throws ArrayIndexOutOfBoundsException {
		if(index == BACK) {
			if(!history.isEmpty()) {
				currentMenu = history.pop();
				return true;
			}  else {
				return false;				
			}
		}
		MenuItem[] menuItems = currentMenu.getMenuItems();
		if(menuItems[index].getAction() != null) {
			menuItems[index].doAction();
		}else {
			history.push(currentMenu);
			currentMenu = menuItems[index].getNextMenu();
			}
		return true;
	}
}
