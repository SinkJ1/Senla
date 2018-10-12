package Task2;
import java.util.Random;

public class randomize {
	Random rand = new Random();
	private int min = 100;
	private int max = 1000;
	public int rand(){
		int a = rand.nextInt(max-min)+min;
		System.out.println("Число "+	 a);  
		return a ;
	}
}
