package UI.ActionUI.MasterAction;

import UI.IAction;
import sort.MasterSort;

public class SortMasterByName implements IAction{

	MasterSort masterSort = new MasterSort();
	
	public void execute() {
		System.out.println(masterSort.getSortByName());
	}
}
