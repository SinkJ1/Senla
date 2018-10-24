package util;

import java.sql.Date;

import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;

import model.Order;

public class OrderUtil  {
	
	private final FileWorker fileWorker;
	
	
	public OrderUtil  (String path) { 
		fileWorker = new TextFileWorker(path);
	}
	
	public Order[] readFromFile() {
		final String[] lines = fileWorker.readFromFile();
		
		if (lines == null || lines.length == 0) {
			throw new IllegalArgumentException();
		}
		
		final Order[] result = new Order[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			result[i] = fromLine(lines[i]);
		}
		
		return result;
	}

	public void writeToFile(Order[] values) {
		if (values == null || values.length == 0) {
			throw new IllegalArgumentException();
		}
		final String[] lines = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			lines[i] = toLine(values[i]);
		}
		fileWorker.writeToFile(lines);
	}

	public String toLine(Order order) {
		if (order == null) {
			throw new IllegalArgumentException();
		}

		final String[] array = new String[] { 
				String.valueOf(order.getId()), 
				String.valueOf(order.getDateOfApplication()), 
				String.valueOf(order.getDateOfCompletion()),
				String.valueOf(order.getDateOfPlannedStartOfExecution()),
				String.valueOf(order.getCost())
			};
		return String.join(";", array);
	}

	public Order fromLine(String line) {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		final String[] parts = line.split(";");

		final Order result = new Order(
				Integer.valueOf(parts[0]), 
				Date.valueOf(parts[1]), 
				Date.valueOf(parts[2]), 
				Date.valueOf(parts[3]), 
				Integer.valueOf(parts[4]),
				parts[5]
			);
		return result;
	}
}