
/** 
 * @author Ahsan Beshal	
 * This program will ask the user for input
 * and then it will respond to whatever the 
 * user has inputted.
 */

import java.util.Scanner;

public class howMuch {

	public static void main(String[] args) {

		// call methods
		displayMessage();
		determine();
	}

	// this method will be the introduction message.
	public static void displayMessage() {
		System.out.println("Hi there, want to know how much");
		System.out.println("in a million, billion and trillion dollars?");
		System.out.println("\n1 Million, Enter A");
		System.out.println("1 Billion, Enter B");
		System.out.println("1 Trillion, Enter C");
		System.out.println();

	}

	// this method will determine user's input and correspond
	// to that message.
	public static void determine() {
		Scanner sc = new Scanner(System.in);
		char userInput = sc.next().charAt(0);

		if (userInput == 'a' || userInput == 'A') {
			System.out.println("\n1 Million is 1000k dollars.");
		} else if (userInput == 'b' || userInput == 'B') {
			System.out.println("\n1 Billion is 1000 Miilion dollars.");
		} else if (userInput == 'c' || userInput == 'C') {
			System.out.println("\n1 Trillion is 1000 Billion dollars.");
		} else
			System.out.println("\nSorry wrong input!");
		sc.close();
	}
}