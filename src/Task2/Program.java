package Task2;

public class Program {

	public static void main(String[] args){
		Randomize rand = new Randomize();
		Number numb = new Number();
		int randNumb  = rand.rand();
		System.out.println("Number " + randNumb);
		System.out.println("Numeral " + numb.maxNumber(randNumb));
	}
	
}