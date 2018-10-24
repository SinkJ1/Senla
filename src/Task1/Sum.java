package Task1;

public class Sum {	
	public static int sum(StringArrayWrapper arrWrapper) {
		int sum = 0;
		for(int i = 0; i < arrWrapper.getLength(); i++){
			sum += Integer.parseInt(arrWrapper.getArr(i));
		}
		return sum;
	}	
}
