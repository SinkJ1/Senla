package administration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.AutoMaster;
import util.AutoMasterUtil;

public class AdmMaster {

	AutoMasterUtil util = new AutoMasterUtil("textFile/AutoMaster.txt");
	Set<AutoMaster> masterFromFile = new HashSet<AutoMaster>(Arrays.asList(util.readFromFile()));

	public void deleteMaster(int id) {
		try {
			for (AutoMaster master : masterFromFile) {
				if (master.getId() == id) {
					masterFromFile.remove(master);

				}
				save();
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
	}

	public void add(int id, String name, int age, String address) {
		AutoMaster uneversalmaster = new AutoMaster(id, name, age, address);
		masterFromFile.add(uneversalmaster);
		save();
	}
	
	public List<AutoMaster> showMaster() {
			return Arrays.asList(util.readFromFile());
	}

	private void save() {
		AutoMaster[] automaster = masterFromFile.toArray(new AutoMaster[masterFromFile.size()]);
		util.writeToFile(automaster);
	}
}
