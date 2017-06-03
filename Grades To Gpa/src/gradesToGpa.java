
/** 
 * @author Ahsan Beshal	
 * 
 * This class will convert your grades to GPA 4.0 scale and letter grade.
 */

import java.util.Scanner;

public class gradesToGpa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double userInput = 0; // user input
		double holdInput = 0; // hold all the input
		int gradeCount = 1; // to update the grade #
		int howManyGrades; // to hold how many grades there will be

		System.out.println("Hi, to calculate your gpa, " + "\nplease enter your grade below.");

		System.out.print("\nHow many grades? ");
		howManyGrades = sc.nextInt();

		System.out.println(); // empty line

		/*
		 * this will loop to user input's number, then update the # for grade
		 * and add the userInput to holdInput
		 */
		for (int i = 0; i < howManyGrades; i++) {
			System.out.print("Grade #" + gradeCount + ": ");
			userInput = sc.nextInt();
			holdInput += userInput;
			gradeCount++;
		}

		sc.close();

		// print Avg, GPA and call the method to execute them
		System.out.print("\nAvg: " + avgGrade(holdInput, howManyGrades));
		System.out.print("\nLetter Grade: " + toLetterGrade(holdInput, howManyGrades));
		System.out.print("\n4.0 Scale GPA: " + toFourPointScale(holdInput, howManyGrades));
	}

	// this method will calculate the avg and return it
	public static double avgGrade(double holdInput, int howManyGrades) {
		double x = holdInput / howManyGrades;
		return x;
	}

	// this method will return a letter grade based on the avg
	public static String toLetterGrade(double holdInput, int howManyGrades) {
		double x = avgGrade(holdInput, howManyGrades); // call avgGrade method
		String letterGrade = ""; // initialize

		if (x >= 97.0 && x <= 100.0) {
			letterGrade = "A+";
		} else if (x >= 93.0 && x <= 96.0) {
			letterGrade = "A";
		} else if (x >= 90.0 && x <= 92.0) {
			letterGrade = "A-";
		} else if (x >= 87.0 && x <= 89.0) {
			letterGrade = "B+";
		} else if (x >= 83.0 && x <= 86.0) {
			letterGrade = "B";
		} else if (x >= 80.0 && x <= 82.0) {
			letterGrade = "B-";
		} else if (x >= 77.0 && x <= 79.0) {
			letterGrade = "C+";
		} else if (x >= 73.0 && x <= 76.0) {
			letterGrade = "C";
		} else if (x >= 70.0 && x <= 72.0) {
			letterGrade = "C-";
		} else if (x >= 67.0 && x <= 69.0) {
			letterGrade = "D+";
		} else if (x >= 65.0 && x <= 66.0) {
			letterGrade = "D";
		} else {
			letterGrade = "F";
		}

		return letterGrade;
	}

	// this method will call the avgGrade method
	// and from there it will determine the 4.0 gpa
	public static double toFourPointScale(double holdInput, int howManyGrades) {
		double x = avgGrade(holdInput, howManyGrades); // call avgGrade method
		double gpa = 0; // initialize

		if (x >= 97.0 && x <= 100.0) {
			gpa = 4.0;
		} else if (x >= 93.0 && x <= 96.0) {
			gpa = 4.0;
		} else if (x >= 90.0 && x <= 92.0) {
			gpa = 3.7;
		} else if (x >= 87.0 && x <= 89.0) {
			gpa = 3.3;
		} else if (x >= 83.0 && x <= 86.0) {
			gpa = 3.0;
		} else if (x >= 80.0 && x <= 82.0) {
			gpa = 2.7;
		} else if (x >= 77.0 && x <= 79.0) {
			gpa = 2.3;
		} else if (x >= 73.0 && x <= 76.0) {
			gpa = 2.0;
		} else if (x >= 70.0 && x <= 72.0) {
			gpa = 1.7;
		} else if (x >= 67.0 && x <= 69.0) {
			gpa = 1.3;
		} else if (x >= 65.0 && x <= 66.0) {
			gpa = 1.0;
		} else {
			gpa = 0.0;
		}

		return gpa;
	}
}
