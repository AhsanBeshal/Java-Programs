
import java.util.Scanner;

public class timeZoneUSA {

	public static void main(String[] args) {

		introMessage();
	}

	public static void introMessage() {
		Scanner sc = new Scanner(System.in);

		String state;
		System.out.println("To know the time zone of a state, enter a state name"
				+ "\nor state abbreviation: ");
		state = sc.next();
		sc.close();
		determineTimeZone(state);
	}

	public static void determineTimeZone(String state) {

		if (state.equals("Alaska")) {
			System.out.println("Bering Time");
		} else if (state.equals("Alabama") || state.equals("AL") || state.equals("Arkansas") || state.equals("AR")
				|| state.equals("Florida") || state.equals("FL") || state.equals("Iowa") || state.equals("IA")
				|| state.equals("Illinois") || state.equals("IL") || state.equals("Indiana") || state.equals("IN")
				|| state.equals("Kansas") || state.equals("KS") || state.equals("Kentucky") || state.equals("KY")
				|| state.equals("Louisiana") || state.equals("LA") || state.equals("Michigan") || state.equals("MI")
				|| state.equals("Minnesota") || state.equals("MN") || state.equals("Missouri") || state.equals("MO")
				|| state.equals("Mississippi") || state.equals("MS") || state.equals("North Dakota")
				|| state.equals("ND") || state.equals("Nebraska") || state.equals("NE") || state.equals("Oklahoma")
				|| state.equals("OK") || state.equals("South Dakota") || state.equals("SD") || state.equals("Tennessee")
				|| state.equals("TN") || state.equals("Texas") || state.equals("TX") || state.equals("Wisconsin")
				|| state.equals("WI")) {
			System.out.println("Central Time");
		} else if (state.equals("Connecticut") || state.equals("CT") || state.equals("Massachusetts")
				|| state.equals("MA") || state.equals("District of Columbia") || state.equals("DC")
				|| state.equals("Maryland") || state.equals("MD") || state.equals("Delaware") || state.equals("DE")
				|| state.equals("Maine") || state.equals("ME") || state.equals("Florida") || state.equals("FL")
				|| state.equals("Michigan") || state.equals("MI") || state.equals("Georgia") || state.equals("GA")
				|| state.equals("North Carolina") || state.equals("NC") || state.equals("Indiana") || state.equals("IN")
				|| state.equals("New Hampshire") || state.equals("NH") || state.equals("Kentucky") || state.equals("KY")
				|| state.equals("New Jersey") || state.equals("NJ") || state.equals("New York") || state.equals("NY")
				|| state.equals("Virginia") || state.equals("VA") || state.equals("Vermont") || state.equals("VT")
				|| state.equals("West Virginia") || state.equals("WV") || state.equals("Rhode Island")
				|| state.equals("RI") || state.equals("Ohio") || state.equals("OH") || state.equals("South Carolina")
				|| state.equals("SC") || state.equals("Pennsylvania") || state.equals("PA") || state.equals("Tennessee")
				|| state.equals("TN")) {
			System.out.println("Eastern Time");
		} else if (state.equals("Hawaii") || state.equals("HI")) {
			System.out.println("Hawaii Time");
		} else if (state.equals("Arizona") || state.equals("AZ") || state.equals("Colorado") || state.equals("CO")
				|| state.equals("Idaho") || state.equals("ID") || state.equals("Kansas") || state.equals("KS")
				|| state.equals("Montana") || state.equals("MT") || state.equals("North Dakota") || state.equals("ND")
				|| state.equals("Nebraska") || state.equals("NE") || state.equals("New Mexico") || state.equals("NM")
				|| state.equals("Oregon") || state.equals("OR") || state.equals("South Dakota") || state.equals("SD")
				|| state.equals("Texas") || state.equals("TX") || state.equals("Utah") || state.equals("UT")
				|| state.equals("Wyoming") || state.equals("WY")) {
			System.out.println("Mountain Time");
		} else if (state.equals("California") || state.equals("CA") || state.equals("Idaho") || state.equals("ID")
				|| state.equals("Nevada") || state.equals("NV") || state.equals("Washington") || state.equals("WA")
				|| state.equals("Oregon") || state.equals("OR")) {
			System.out.println("Pacific Time");
		} else {
			System.out.println("Wrong input!");
		}

	}

}
