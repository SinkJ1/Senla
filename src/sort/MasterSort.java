package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import model.AutoMaster;
import util.AutoMasterUtil;

public class MasterSort {
		AutoMasterUtil util = new AutoMasterUtil("E:\\Users\\Admin\\eclipse-workspace\\LIST_4\\textFile\\test.txt");
		
		public  List<AutoMaster> getAlphabetically() { // sort by name
			List<AutoMaster> listmaster = toList();
			listmaster.sort(Comparator.comparing(AutoMaster::getName));
			return listmaster;
		}
		
		public  List<AutoMaster> getByEmployment() { // sort by employment
			List<AutoMaster> listmaster = toList();
			listmaster.sort(Comparator.comparing(AutoMaster::getEmployment));
			return listmaster;
		}

		private  List<AutoMaster> toList() { 
			return Arrays.asList(util.readFromFile()); 
		} 
}
