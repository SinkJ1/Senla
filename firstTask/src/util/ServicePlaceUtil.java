package util;

import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;
import model.ServicePlace;
import model.AutoMaster;

public class ServicePlaceUtil {

	private final FileWorker fileWorker;

	public ServicePlaceUtil(String path) {
		fileWorker = new TextFileWorker(path);
	}

	public ServicePlace[] readFromFile() {
		final String[] lines = fileWorker.readFromFile();

		if (lines == null || lines.length == 0) {
			throw new IllegalArgumentException();
		}

		final ServicePlace[] result = new ServicePlace[lines.length];

		for (int i = 0; i < lines.length; i++) {
			result[i] = fromLine(lines[i]);
		}

		return result;
	}

	public void writeToFile(ServicePlace[] values) {
		if (values == null || values.length == 0) {
			throw new IllegalArgumentException();
		}
		final String[] lines = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			lines[i] = toLine(values[i]);
		}
		fileWorker.writeToFile(lines);
	}

	public static String toLine(ServicePlace servicePlace) {
		if (servicePlace == null) {
			throw new IllegalArgumentException();
		}

		final String[] array = new String[] { 
				String.valueOf(servicePlace.getId()),
				String.valueOf(servicePlace.getStatus()), 
				String.valueOf(servicePlace.getMasterid().getId()),
				String.valueOf(servicePlace.getMasterId2().getId())
				
		};
		return String.join(";", array);
	}

	public static ServicePlace fromLine(String line) {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		final String[] parts = line.split(";");
		AutoMaster master = null;
		AutoMaster master2 = null;
		Integer id = Integer.valueOf(parts[2]);
		Integer id2 = Integer.valueOf(parts[3]);
		AutoMasterUtil masterUtil = new AutoMasterUtil("textFile/AutoMaster.txt");
		AutoMaster[] masters = masterUtil.readFromFile();
		for (AutoMaster autoMaster : masters) {
			for (AutoMaster autoMaster2 : masters) {
				if (autoMaster.getId() == id && autoMaster2.getId() == id2) {
					master = autoMaster;
					master2 = autoMaster2;
					break;
				}
			}
		}

		final ServicePlace result = new ServicePlace(
				
				Integer.valueOf(parts[0]), 
				Boolean.valueOf(parts[1]), 
				master,
				master2
				
				);
		return result;
	}

}
