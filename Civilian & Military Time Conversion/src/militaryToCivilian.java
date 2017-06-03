
/**
 * @author Ahsan Beshal
 *
 * This class will convert military time to civilian time.
 */

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class militaryToCivilian {

	public static void main(String[] args) throws Exception {
	
		output(time());
	}
	
	// ask the user for time and hold as string
	public static String time() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter time: ");
		String time = sc.nextLine();
		sc.close();
		return time;
	}
	
	// print out the results
	public static void output(String time) throws Exception {
		SimpleDateFormat displayFormat = new SimpleDateFormat("h:mm a");
		SimpleDateFormat parseFormat = new SimpleDateFormat("HHmm");
		Date date = parseFormat.parse(time);

		System.out.println();
		System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));
	}
}