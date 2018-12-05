package UI;

import java.util.Scanner;


public class MenuController {

	public static void main(String[] args) {
		boolean running = true;
		Navigator nA = new Navigator(RootMenu.getInstance());
		Scanner in = new Scanner(System.in);
		int i = 0;
		while(running) {
			nA.printMenu();
			try {
				i = in.nextInt();
				running = nA.navigate(i);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.err.println("Out of range, Please try again!");
			}			
		}
		System.out.println("Good Buy");
	}
} 