package Task2;

public class number {
	
	public void rand1(int a){
		String str = Integer.toString(a);
		int length = str.length();
		int max_numb = 0;
		for (int i = 0;	i < length ;i++){
			int cc = a%10;
			a = a/10;
			if (cc > max_numb)
				max_numb = cc;		
		}
		System.out.println("max цифра " + max_numb);  
	}
}
