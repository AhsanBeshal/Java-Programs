
/**
 * This class does few things, it converts the city's name to zipcode. It gets the database's results, then it figures out
 * what to remove from the ArrayList depending from the driver's input. Then it will decide what time frame the results fall
 * in. 
 *
 * @author (Ahsan Beshal)
 * Date: 06/27/2017 
 * 
 * Ways to iterate through an ArrayList: http://crunchify.com/how-to-iterate-through-java-list-4-way-to-iterate-through-loop/
 */

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Results extends JFrame {

	private JPanel contentPane;

	// it will be used to get database's data
	private Statement statement = null;
	private ResultSet resultSet = null;

	// this class's instance variables to set it to the values passed from Input
	// class
	private String driverCityInput;
	private int driver_location_x;
	private int driver_location_y;

	// declare the ArrayLists, so it can be used to set each column values from
	// the database
	private ArrayList<String> receiver_id = new ArrayList<String>();
	private ArrayList<String> receiver_lastname = new ArrayList<String>();
	private ArrayList<String> receiver_firstname = new ArrayList<String>();
	private ArrayList<String> receiver_phone_num = new ArrayList<String>();
	private ArrayList<String> receiver_address = new ArrayList<String>();
	private ArrayList<Integer> receiver_location_x = new ArrayList<Integer>();
	private ArrayList<Integer> receiver_location_y = new ArrayList<Integer>();
	private ArrayList<Integer> combined_receiver_location_x_y = new ArrayList<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Results frame = new Results("", (Integer) null, (Integer) null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connect = null;

	/**
	 * Constructor.
	 * 
	 * @throws SQLException
	 */
	public Results(String driverCityInput, int driver_location_x, int driver_location_y) throws SQLException {
		this.driverCityInput = driverCityInput;
		this.driver_location_x = driver_location_x;
		this.driver_location_y = driver_location_y;

		// this will be used to set the driver's x and y inputs from Input class
		int combined_driver_location_x_y = driver_location_x + driver_location_y;

		// connect to Database
		connect = DatabaseConnect.postgresqlConnection();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("UPS");

		// call method and pass the local variable
		getZipcode(combined_driver_location_x_y);

		if (deliveryComingUp(combined_driver_location_x_y) == "No upcoming deliveries") {
			JLabel lblDeliveryMsg = new JLabel(deliveryComingUp(combined_driver_location_x_y));
			lblDeliveryMsg.setFont(new Font("Courier", Font.PLAIN, 13));
			lblDeliveryMsg.setBounds(6, 18, 258, 16);
			contentPane.add(lblDeliveryMsg);
		} else {
			JLabel lblDeliveryMsg = new JLabel(deliveryComingUp(combined_driver_location_x_y));
			lblDeliveryMsg.setFont(new Font("Courier", Font.PLAIN, 13));
			lblDeliveryMsg.setBounds(6, 18, 258, 16);
			contentPane.add(lblDeliveryMsg);

			JLabel lblReceiverID = new JLabel("Receiver ID: " + receiver_id.get(getMinIndex()));
			lblReceiverID.setFont(new Font("Courier", Font.PLAIN, 13));
			lblReceiverID.setBounds(6, 46, 258, 16);
			contentPane.add(lblReceiverID);

			JLabel lblReceiverFirstName = new JLabel("Receiver First Name: " + receiver_firstname.get(getMinIndex()));
			lblReceiverFirstName.setFont(new Font("Courier", Font.PLAIN, 13));
			lblReceiverFirstName.setBounds(6, 74, 258, 16);
			contentPane.add(lblReceiverFirstName);

			JLabel lblReceiverLastName = new JLabel("Receiver Last Name: " + receiver_lastname.get(getMinIndex()));
			lblReceiverLastName.setFont(new Font("Courier", Font.PLAIN, 13));
			lblReceiverLastName.setBounds(6, 102, 258, 16);
			contentPane.add(lblReceiverLastName);

			JLabel lblReceiverPhoneNumber = new JLabel(
					"Receiver Phone Number: " + receiver_phone_num.get(getMinIndex()));
			lblReceiverPhoneNumber.setFont(new Font("Courier", Font.PLAIN, 13));
			lblReceiverPhoneNumber.setBounds(6, 130, 342, 16);
			contentPane.add(lblReceiverPhoneNumber);

			JLabel lblReceiverAddress = new JLabel("Receiver Address: " + receiver_address.get(getMinIndex()));
			lblReceiverAddress.setFont(new Font("Courier", Font.PLAIN, 13));
			lblReceiverAddress.setBounds(6, 158, 438, 16);
			contentPane.add(lblReceiverAddress);
		}
	}

	/**
	 * This method is responsible for converting the city name string to
	 * zipcode, which will be used to get the database's data. It takes one
	 * parameter which will be used to pass it to other method.
	 *
	 * @param int
	 *            combined_driver_location_x_y
	 * 
	 */
	public void getZipcode(int combined_driver_location_x_y) throws SQLException {

		int zipcode = 0;
		String query = "select zipcode from cities where cityname = " + "'" + driverCityInput + "'";

		// 2. Create a statement
		statement = connect.createStatement();

		try {

			// 3. Execute SQL query
			resultSet = statement.executeQuery(query);

			// 4. Process the resultSet set
			while (resultSet.next()) {
				zipcode = resultSet.getInt("zipcode");
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}
		}

		// call the next method
		getQueryResults(zipcode, combined_driver_location_x_y);

	}

	/**
	 * This method is responsible for getting the query results. It will use the
	 * parameter zipcode that was converted from getZipcode() method and get the
	 * data from only that specific city. As for parameter zipcode
	 * combined_driver_location_x_y it will compare it to
	 * combined_receiver_location_x_y then it will determine which column to
	 * remove.
	 *
	 * @param int zipcode, int combined_driver_location_x_y
	 * 
	 */
	public void getQueryResults(int zipcode, int combined_driver_location_x_y) throws SQLException {

		// query to execute
		String query = "select receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, "
				+ "receiver_address, receiver_location_x, receiver_location_y, receiver_location_x + "
				+ "receiver_location_y as combined_receiver_location_x_y from receiver where zipcode = " + zipcode;

		// 2. Create a statement
		statement = connect.createStatement();

		try {

			// 3. Execute SQL query
			resultSet = statement.executeQuery(query);

			// 4. Process the resultSet set
			while (resultSet.next()) {

				String r_id = resultSet.getString("receiver_id");
				String r_lastname = resultSet.getString("receiver_lastname");
				String r_firstname = resultSet.getString("receiver_firstname");
				String r_phone_num = resultSet.getString("receiver_phone_num");
				String r_address = resultSet.getString("receiver_address");
				int r_location_x = resultSet.getInt("receiver_location_x");
				int r_location_y = resultSet.getInt("receiver_location_y");
				int combined_r_location_x_y = resultSet.getInt("combined_receiver_location_x_y");

				// populate the ArrayList
				receiver_id.add(r_id);
				receiver_lastname.add(r_lastname);
				receiver_firstname.add(r_firstname);
				receiver_phone_num.add(r_phone_num);
				receiver_address.add(r_address);
				receiver_location_x.add(r_location_x);
				receiver_location_y.add(r_location_y);
				combined_receiver_location_x_y.add(combined_r_location_x_y);

			}

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}
		}

		// iterate through the ArrayList.
		for (int i = 0; i < combined_receiver_location_x_y.size(); i++) {

			// compare, if greater then find the index of the minimum of
			// combined_receiver_location_x_y and remove it
			// from the ArrayList
			if (combined_driver_location_x_y > combined_receiver_location_x_y.get(i)) {
				int minIndex = combined_receiver_location_x_y.indexOf(Collections.min(combined_receiver_location_x_y));
				receiver_id.remove(minIndex);
				receiver_lastname.remove(minIndex);
				receiver_firstname.remove(minIndex);
				receiver_phone_num.remove(minIndex);
				receiver_address.remove(minIndex);
				receiver_location_x.remove(minIndex);
				receiver_location_y.remove(minIndex);
				combined_receiver_location_x_y.remove(minIndex);

				// if one of the ArrayList's size goes below zero, then break
				// out of the loop, otherwise it will throw
				// indexoutofboundsexception
				if (receiver_id.size() < 0) {
					break;
				}
			}
		}
	}

	/**
	 * This method's purpose is to find the index of the minimum value of
	 * (combined_receiver_location_x_y), it will then be used to print the
	 * corresponding row, so for example if the combined x_y is 120 and other
	 * ones 134, 140 it will use the 120 one because it is closest and return
	 * the index.
	 * 
	 * @return index of minimum combined_receiver_location_x_y
	 * 
	 */
	public int getMinIndex() {

		return combined_receiver_location_x_y.indexOf(Collections.min(combined_receiver_location_x_y));

	}

	/**
	 * This method is responsible for getting the distance from using the
	 * distance formula. It uses driver_location_x as X2, driver_location_y as
	 * Y2, receiver_location_x as X1 and receiver_location_y as Y1.
	 *
	 * @return distance
	 *
	 */
	public double getDistance() {

		double distance = 0;

		distance = Math.pow((driver_location_x - receiver_location_x.get(getMinIndex())), 2)
				+ Math.pow((driver_location_y - receiver_location_y.get(getMinIndex())), 2);

		return Math.sqrt(distance);

	}

	/**
	 * This method will use the getDistance() formula to notify the driver of
	 * any upcoming deliveries and return how much time it will take as a
	 * string.
	 * 
	 * @return String
	 * 
	 */
	public String deliveryComingUp(int combined_driver_location_x_y) {

		// find the maximum value in the ArrayList
		// combined_receiver_location_x_y
		int maxVal = Collections.max(combined_receiver_location_x_y);

		if (combined_driver_location_x_y < maxVal) {
			if (getDistance() >= 10 && getDistance() <= 15) {
				return "Delivery in 15 minutes";
			} else if (getDistance() >= 5 && getDistance() <= 10) {
				return "Delivery in 10 minutes";
			} else if (getDistance() >= 0 && getDistance() <= 5) {
				return "Delivery in 5 minutes";
			}
		}
		return "No upcoming deliveries";
	}
}
