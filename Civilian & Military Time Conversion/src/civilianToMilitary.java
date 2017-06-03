
/**
 * @author Ahsan Beshal
 *	
 * This class will convert civilian time to military time.
 */

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class civilianToMilitary {

	public static void main(String[] args) throws Exception {

		output(time());
	}

	// ask the user for time and hold as string
	public static String time() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter time with am or pm: ");
		String time = sc.nextLine();
		sc.close();
		return time;
	}

	// print out the results
	public static void output(String time) throws Exception {
		SimpleDateFormat displayFormat = new SimpleDateFormat("HHmm");
		SimpleDateFormat parseFormat = new SimpleDateFormat("h:mm a");
		Date date = parseFormat.parse(time);

		System.out.println();
		System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));
	}
}