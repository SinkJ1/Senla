package Task2;

public class Program {

	public static void main(String[] args){
		Randomize rand = new Randomize();
		Number numb = new Number();
		int rand_numb  = rand.rand();
		System.out.println("Number " + rand_numb);
		System.out.println("Numeral " + numb.MaxNumber(rand_numb));
	}
	
}