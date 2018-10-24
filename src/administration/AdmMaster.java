package administration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import model.AutoMaster;
import util.AutoMasterUtil;

public class AdmMaster {
		Scanner in = new Scanner(System.in);
		AutoMasterUtil util = new AutoMasterUtil("E:\\Users\\Admin\\eclipse-workspace\\LIST_4\\textFile\\test.txt");
		List<AutoMaster> masterFromFile = new ArrayList<AutoMaster>(Arrays.asList(util.readFromFile()));
			
		public void deleteMaster() {	//delete master id = 1 
			try {
				for (AutoMaster master : masterFromFile) {
					if (master.getId() == 1 ) {
						masterFromFile.remove(master);
					}
					save();
				}
			}catch(Exception ex) {
				ex.getMessage();
			}
		}
		public void changeName() {		//change name master  id = 3
			for (AutoMaster master : masterFromFile) {
					if (master.getId() == 3 ) {
						master.setName("Petja");
					}
					save();
				}
		}
		
		public void add() { // adding master
			AutoMaster uneversalmaster = new AutoMaster(in.nextInt(), in.next(), in.nextInt(), in.next(), in.nextBoolean());
			masterFromFile.add(uneversalmaster);	
			save();
		}
		
		public void save() { // saving changes to file 
			AutoMaster[] automaster = masterFromFile.toArray(new AutoMaster[masterFromFile.size()]);
			util.writeToFile(automaster);
		}
}
