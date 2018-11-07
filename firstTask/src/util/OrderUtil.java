package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;
import Enum.OrderState;
import model.Order;
import model.ServicePlace;
import util.ServicePlaceUtil;

public class OrderUtil {

	private final FileWorker fileWorker;

	public OrderUtil(String path) {
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

		DateFormat dateFormat = new SimpleDateFormat("dd - MM - yyyy");
		final String[] array = new String[] { 
				
				String.valueOf(order.getId()), 
				String.valueOf(order.getCost()),
				String.valueOf(order.getPlaceid().getId()), 
				String.valueOf(order.getState()),
				dateFormat.format(order.getDateOfApplication()), 
				dateFormat.format(order.getDateOfCompletion()),
				dateFormat.format(order.getDateOfPlannedStartOfExecution()) 
				
		};
		return String.join(";", array);
	}

	public Order fromLine(String line) {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		DateFormat dateFormat = new SimpleDateFormat("dd - MM - yyyy");
		final String[] parts = line.split(";");
		ServicePlace place = null;
		Integer id = Integer.valueOf(parts[2]);
		ServicePlaceUtil placeUtil = new ServicePlaceUtil("textFile/place.txt");
		ServicePlace[] places = placeUtil.readFromFile();
		for (ServicePlace servPlace : places) {
			if (servPlace.getId() == id) {
				place = servPlace;
				break;
			}
		}

		Order result = null;
		try {
			result = new Order(Integer.valueOf(parts[0]), 
					Integer.valueOf(parts[1]), 
					place,
					OrderState.valueOf(parts[3]), 
					dateFormat.parse(parts[4]), 
					dateFormat.parse(parts[5]),
					dateFormat.parse(parts[6]));
		} catch (Exception ex) {
			ex.getMessage();
		}
		return result;
	}
}