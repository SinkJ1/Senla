package Task2;

public class Number {
	
	public int MaxNumber(int a){
		String str = Integer.toString(a);
		int length = str.length();
		int max_numb = 0;
		for (int i = 0;	i < length; i++){
			int numb = a % 10;
			a = a / 10;
			if (numb > max_numb) {
				max_numb = numb;	
			}
		}
		return max_numb;
	}
}
