package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import model.AutoMaster;
import util.AutoMasterUtil;

public class MasterSort {
	AutoMasterUtil util = new AutoMasterUtil("textFile/AutoMaster.txt");

	public List<AutoMaster> getSortByName() {
		return sortByName(writeToList());
	}

	private List<AutoMaster> sortByName(List<AutoMaster> listmaster) { // sort by name
		listmaster.sort(Comparator.comparing(AutoMaster::getName));
		return listmaster;
	}

	private List<AutoMaster> writeToList() {
		return Arrays.asList(util.readFromFile());
	}
}
