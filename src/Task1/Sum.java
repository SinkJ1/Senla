package Task1;

public class Sum {	
	public static int sum(StringArrayWrapper ArrWrapper) {
		int sum = 0;
		for(int i = 0; i < ArrWrapper.getlength(); i++){
			sum += Integer.parseInt(ArrWrapper.getArr(i));
		}
		return sum;
	}	
}
