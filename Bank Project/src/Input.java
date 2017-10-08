
/**
 * This project should be launched from Input class first!!!
 * 
 * This class is responsible for getting an input from the user using Jframe and pass the instance variables to Output
 * class to be used there if input is correct or not.
 * 
 *
 * @author (Ahsan Beshal)
 * Date: 06/13/2017 
 * 
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Input {

	private JFrame frame;
	private JLabel lblWelcomeToUnited;
	private JPasswordField inputField;
	private JLabel lblForAssistanceCall;

	private String userInput; // this will hold the user input

	// instance variables to set it to results processed from resultSet() methods
	private String firstname;
	private String lastname;
	private int accountNum;
	private double balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Input window = new Input();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connect = null;

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public Input() throws SQLException {

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() throws SQLException {

		// get connected to database
		connect = DatabaseConnect.postgresqlConnection();

		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("User Input"); // set a title

		lblWelcomeToUnited = new JLabel("Welcome to United Bank");
		lblWelcomeToUnited.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblWelcomeToUnited.setBounds(135, 57, 185, 13);
		frame.getContentPane().add(lblWelcomeToUnited);

		JLabel lblNewLabel = new JLabel("Enter last 4 digits of your account number to begin");
		lblNewLabel.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(23, 73, 418, 35);
		frame.getContentPane().add(lblNewLabel);

		inputField = new JPasswordField();
		inputField.setBounds(174, 113, 91, 26);
		frame.getContentPane().add(inputField);

		JButton btnEnter = new JButton("Enter ");
		btnEnter.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		btnEnter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				userInput = (inputField.getText());

				try {
					resultSet(); // call resultSet method
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		btnEnter.setForeground(Color.BLACK);
		btnEnter.setBackground(Color.LIGHT_GRAY);
		btnEnter.setBounds(97, 151, 250, 29);
		frame.getContentPane().add(btnEnter);

		lblForAssistanceCall = new JLabel("For assistance call 1-800-902-8108");
		lblForAssistanceCall.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblForAssistanceCall.setBounds(90, 190, 272, 16);
		frame.getContentPane().add(lblForAssistanceCall);

	}

	/**
	 * This method executes the query and stores them in instance variables. It
	 * also checks the user input against the information on the database, if it
	 * matches then pass the instance variables to Output class to be used
	 * there, if it does not match then show error message and let the user try
	 * again.
	 * 
	 * @throws SQLException
	 */
	public void resultSet() throws SQLException {

		Statement statement = null;
		ResultSet resultSet = null;

		String query = "select firstname, lastname, balances.acctid, balances.balance from customers, balances where customers.acctid = balances.acctid and balances.acctid = "
				+ userInput;

		// 2. Create a statement
		statement = connect.createStatement();

		try {

			// 3. Execute SQL query
			resultSet = statement.executeQuery(query);

			// 4. Process the resultSet set
			while (resultSet.next()) {
				firstname = resultSet.getString("firstname");
				lastname = resultSet.getString("lastname");
				accountNum = resultSet.getInt("acctid");
				balance = resultSet.getDouble("balance");
			}

			// this will convert the user input to integer
			int userInputCon = Integer.parseInt(userInput);

			// it will be used here to check if it matches in database
			if (userInputCon == accountNum) {

				// if it does then do the following
				Output output;
				try {
					// pass instance variables to Output class
					output = new Output(firstname, lastname, accountNum, balance);
					// open Output class's window
					output.setVisible(true);
					// close Input class's window
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}

				// if not then show error message
			} else {

				JOptionPane.showMessageDialog(null, "Wrong Account Number! Try Again");

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
	}
}