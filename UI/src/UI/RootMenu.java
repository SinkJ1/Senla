package UI;

import UI.menuItemsUI.MenuAutoMaster;
import UI.menuItemsUI.MenuOrder;
import UI.menuItemsUI.MenuServicePlace;

public class RootMenu {

	private static RootMenu instance;
	
	private static Menu rootMenu;
	
	public RootMenu() {
		rootMenu = new Menu("Root menu");
	}

	private void buildMenu() {
		MenuItem master = new MenuItem("Auto Master", null, MenuAutoMaster.getInstance());
		MenuItem order = new MenuItem("Order", null, MenuOrder.getInstance());
		MenuItem place =  new MenuItem("Place", null, MenuServicePlace.getInstance());
		
		MenuItem[] items = {master, order, place};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(instance == null) {
			instance = new RootMenu();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
