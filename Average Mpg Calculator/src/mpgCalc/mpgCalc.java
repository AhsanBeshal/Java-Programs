
package mpgCalc;

/** 
 * @author Ahsan Beshal	
	
 * This program will calculate your average mpg.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class mpgCalc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");

		// to update the trip number
		int countTrip = 1;

		// to hold gas price, how much user got
		// and hold trip input miles
		double gasPrice, howMuch, expectedMpg;

		// Initialize
		double userInput = 0;
		double tripInput = 0;
		double holdInput = 0;

		System.out.println("Hi, In this program, you will be allowed to "
				+ "\nenter as many miles per trip as you want to " + "\ncalculate your avg mpg for your car.");

		System.out.print("\nHow many trips? ");
		userInput = sc.nextDouble();

		System.out.print("How much per gallon? $");
		gasPrice = sc.nextDouble();

		System.out.print("How much did you get? $");
		howMuch = sc.nextDouble();

		System.out.print("Your expected avg mpg? ");
		expectedMpg = sc.nextDouble();

		System.out.println();

		// this loop will keep going until user's
		// condition is met and also ask the user
		// for trip input and also update trip #
		for (int i = 0; i < userInput; i++) {
			System.out.print("Trip #" + countTrip + ": ");
			tripInput = sc.nextDouble();
			holdInput += tripInput;
			countTrip++;
		}

		sc.close();

		System.out.println("\nTotal miles: " + holdInput);
		System.out.println("Expected average mpg: " + expectedMpg);

		double holdAvgMpg = avgMpg(holdInput, howMuch, gasPrice);
		System.out.println("Average mpg: " + df.format(holdAvgMpg));

		double ansToAbs = Math.abs(expectedMpg - holdAvgMpg);
		System.out.println("Average mpg difference: " + df.format(ansToAbs));

	}

	// this method will take in tripInput, howMuch and gasPrice
	// it will calculate the average mpg by getting how many gallons
	// from the other method
	public static double avgMpg(double holdInput, double howMuch, double gasPrice) {
		double x;
		x = holdInput / getGallons(howMuch, gasPrice);
		return x;
	}

	// this method will take in howMuch and gasPrice to return
	// how many gallons
	public static double getGallons(double howMuch, double gasPrice) {
		double x = howMuch / gasPrice;
		return x;
	}

}
