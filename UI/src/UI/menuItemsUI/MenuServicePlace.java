package UI.menuItemsUI;

import UI.Menu;
import UI.MenuItem;
import UI.ActionUI.OrderAction.CountFreePlaceInFuture;
import UI.ActionUI.PlaceAction.AddPlace;
import UI.ActionUI.PlaceAction.ShowFreePlace;
import UI.ActionUI.PlaceAction.ShowPlace;

public class MenuServicePlace {
	
	private static MenuServicePlace instance;
	private static Menu rootMenu;
	
	private MenuServicePlace() {
		rootMenu = new Menu("ServicePlace Menu");
	}
	
	private void buildMenu() {
		
		MenuItem show = new MenuItem("show", new ShowPlace(), null);
		MenuItem showFreePlace = new MenuItem("showFreePlace", new ShowFreePlace(), null);
		MenuItem add = new MenuItem("Add Place", new AddPlace(),null);
		MenuItem countFreePlaceInFuture = new MenuItem("count Free Place In Future", new CountFreePlaceInFuture(),null);
		
		MenuItem[] items = {show,showFreePlace,add,countFreePlaceInFuture};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(rootMenu == null) {
			instance = new MenuServicePlace();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
