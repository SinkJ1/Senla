package Task1;

public class Sum {	
	public static void sum(ElMas el) {
		int b = 0;
		for(int i = 0;i<el.getlength();i++){
			int a = Integer.parseInt(el.getElMas(i));
			b = b+a;
		}
		System.out.println("Сумма =  " + b);
	}
	
}
