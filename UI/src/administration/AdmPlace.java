package administration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import model.AutoMaster;
import model.Order;
import model.ServicePlace;
import util.AutoMasterUtil;
import util.ServicePlaceUtil;
import java.util.Set;

public class AdmPlace {
	ServicePlaceUtil serviceUtil = new ServicePlaceUtil("textFile/place.txt");
	Set<ServicePlace> placeFromFile = new HashSet<ServicePlace>(Arrays.asList(serviceUtil.readFromFile()));
	AutoMasterUtil util = new AutoMasterUtil("textFile/AutoMaster.txt");
	Set<AutoMaster> masterFromFile = new HashSet<AutoMaster>(Arrays.asList(util.readFromFile()));

	public void addPlace(int idPlace, int idFirstMaster, int idTwoMaster) {
		for (AutoMaster master : masterFromFile) {
			for (AutoMaster master2 : masterFromFile) {
				if (master.getId() == idFirstMaster && master2.getId() == idTwoMaster) {
					ServicePlace newPlace = new ServicePlace(idPlace, true, master, master2);
					placeFromFile.add(newPlace);
					save();
				}
			}
		}
	}

	public List<ServicePlace> freePlace() { // free place
		List<ServicePlace> servPlace = new ArrayList<ServicePlace>();
		for (ServicePlace place : placeFromFile) {
			if (place.getStatus() == true) {
				servPlace.add(place);
			}
		}
		return servPlace;
	}
	
	public List<ServicePlace> showPlace(){
		return Arrays.asList(serviceUtil.readFromFile());
	}

	private void save() {
		ServicePlace[] place = placeFromFile.toArray(new ServicePlace[placeFromFile.size()]);
		serviceUtil.writeToFile(place);
	}
}
