package Task2;

public class Number {
	
	public int maxNumber(int a){
		String str = Integer.toString(a);
		int length = str.length();
		int maxNumb = 0;
		for (int i = 0;	i < length; i++){
			int numb = a % 10;
			a = a / 10;
			if (numb > maxNumb) {
				maxNumb = numb;	
			}
		}
		return maxNumb;
	}
}
