package UI.menuItemsUI;

import UI.Menu;
import UI.MenuItem;
import UI.ActionUI.MasterAction.AddMaster;
import UI.ActionUI.MasterAction.DeleteMaster;
import UI.ActionUI.MasterAction.FindMasterByOrder;
import UI.ActionUI.MasterAction.ShowMaster;
import UI.ActionUI.MasterAction.SortMasterByName;

public class MenuAutoMaster {
	
	private static MenuAutoMaster instance;
	private static Menu rootMenu;
	
	public MenuAutoMaster() {
		rootMenu = new Menu("AutoMaster menu");
	}

	private void buildMenu() {
		MenuItem show = new MenuItem("Show Master", new ShowMaster(), null);
		MenuItem delete = new MenuItem("Delete Master", new DeleteMaster(), null);
		MenuItem add = new MenuItem("Add Master", new AddMaster(),null);
		MenuItem find = new MenuItem("Find Master", new FindMasterByOrder(),null);
		MenuItem sort = new MenuItem("Sort Master By Name",new SortMasterByName(),null);
		MenuItem[] items = {show, delete, add,find,sort};
		
		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if(rootMenu == null) {
			instance = new MenuAutoMaster();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
