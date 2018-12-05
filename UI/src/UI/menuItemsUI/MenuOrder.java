package UI.menuItemsUI;

import UI.Menu;
import UI.MenuItem;
import UI.ActionUI.OrderAction.AddOrder;
import UI.ActionUI.OrderAction.ChangeDateCompletionOrder;
import UI.ActionUI.OrderAction.FindOrderByMaster;
import UI.ActionUI.OrderAction.ShowOrder;
import UI.ActionUI.OrderAction.SortOrderByCost;
import UI.ActionUI.OrderAction.SortOrderByDateOfApplication;
import UI.ActionUI.OrderAction.SortOrderByDateOfCompletion;
import UI.ActionUI.OrderAction.SortOrderByPeriodTimeByCost;
import UI.ActionUI.OrderAction.SortOrderByPeriodTimeByDateOfApplication;
import UI.ActionUI.OrderAction.SortOrderByPeriodTimeByDateOfCompletion;
import UI.ActionUI.OrderAction.SortOrderByPlannedDateOfExecution;
import UI.ActionUI.OrderAction.UpdateStateOrder;

public class MenuOrder {
	private static MenuOrder instance;
	private static Menu rootMenu;

	private MenuOrder() {
		rootMenu = new Menu("Order menu");
	}

	private void buildMenu() {
		MenuItem addOrder = new MenuItem("Add order", new AddOrder(), null);
		MenuItem changeDateOfCompletion = new MenuItem("changeDateOfCompletion", new ChangeDateCompletionOrder(), null);
		MenuItem findOrderByMaster = new MenuItem("find order by master", new FindOrderByMaster(), null);
		MenuItem showOrder = new MenuItem("show order", new ShowOrder(), null);
		MenuItem updateState = new MenuItem("change state by order", new UpdateStateOrder(), null);
		MenuItem sortByCost = new MenuItem("sort By Cost", new SortOrderByCost(), null);
		MenuItem sortByDateOfApplication = new MenuItem("sort By Date Of Application",
				new SortOrderByDateOfApplication(), null);
		MenuItem sortByDateOfCompletion = new MenuItem("sort By Date Of Completion", new SortOrderByDateOfCompletion(),
				null);
		MenuItem sortByPlannedDateOfExecution = new MenuItem("sort By Planned Date Of Execution",
				new SortOrderByPlannedDateOfExecution(), null);
		MenuItem sortByPeriodTimeByCost = new MenuItem("sort By Period Time By Cost", new SortOrderByPeriodTimeByCost(),
				null);
		MenuItem sortByPeriodTimeByDateOfCompletion = new MenuItem("sort By Period Time By Date Of Completion",
				new SortOrderByPeriodTimeByDateOfCompletion(), null);
		MenuItem sortByPeriodTimeByDateOfApplication = new MenuItem("sortByPeriodTimeByDateOfApplication",
				new SortOrderByPeriodTimeByDateOfApplication(), null);
		
		MenuItem[] items = { addOrder, changeDateOfCompletion, findOrderByMaster, showOrder, updateState, sortByCost,
				sortByDateOfApplication, sortByDateOfCompletion, sortByPlannedDateOfExecution, sortByPeriodTimeByCost,
				sortByPeriodTimeByDateOfCompletion, sortByPeriodTimeByDateOfApplication };

		rootMenu.setMenuItems(items);
	}

	public static Menu getInstance() {
		if (rootMenu == null) {
			instance = new MenuOrder();
			instance.buildMenu();
		}
		return rootMenu;
	}
}
