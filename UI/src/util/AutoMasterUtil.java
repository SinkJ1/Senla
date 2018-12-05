package util;

import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;

import model.AutoMaster;

public class AutoMasterUtil {

	private final FileWorker fileWorker;

	public AutoMasterUtil(String path) {
		fileWorker = new TextFileWorker(path);
	}

	public AutoMaster[] readFromFile() {
		final String[] lines = fileWorker.readFromFile();

		if (lines == null || lines.length == 0) {
			throw new IllegalArgumentException();
		}

		final AutoMaster[] result = new AutoMaster[lines.length];

		for (int i = 0; i < lines.length; i++) {
			result[i] = fromLine(lines[i]);
		}

		return result;
	}

	public void writeToFile(AutoMaster[] values) {
		if (values == null || values.length == 0) {
			throw new IllegalArgumentException();
		}
		final String[] lines = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			lines[i] = toLine(values[i]);
		}
		fileWorker.writeToFile(lines);
	}

	public String toLine(AutoMaster autoMaster) {
		if (autoMaster == null) {
			throw new IllegalArgumentException();
		}

		final String[] array = new String[] { 
				
				String.valueOf(autoMaster.getId()), 
				autoMaster.getName(),
				String.valueOf(autoMaster.getAge()), 
				String.valueOf(autoMaster.getAddress()) 
				
		};
		return String.join(";", array);
	}

	public AutoMaster fromLine(String line) {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		final String[] parts = line.split(";");

		final AutoMaster result = new AutoMaster(
				
				Integer.valueOf(parts[0]), 
				parts[1], 
				Integer.valueOf(parts[2]),
				parts[3]);
		
		return result;
	}
}