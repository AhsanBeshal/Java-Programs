
/**
 * This class is responsible for giving the user 3 options after they see their balance. It will accept instance variables
 * from Input class that will be used to set it to this class's instance variables by using the constructor. 
 * 
 * **Side note: We did not use setters/getters in this class to set (firstname = fromInFname) because constructor 
 * does it for us and we do not need access to them in any other classes because anything we get from processing 
 * the queries we have to pass them as parameter to use it in other classes. When we create new instance of a class
 * it asks for a parameter but we cannot give any new parameters because it will change the database results.
 * 
 * **Side note: Constructor gets executed when instance of a class is created example:(Output output = new Output(input)), 
 * input was passed so it can be initialized in the constructor and then using setters/getters to use it throughout
 * the class.
 * 
 *
 * @author (Ahsan Beshal)
 * Date: 06/13/2017 
 * 
 */

import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Output extends JFrame {

	private JPanel contentPane;

	// this class's instance variables to set it to values passed from Input class
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
					// set the parameter as null
					Output frame = new Output("", "", (Integer) null, (Double) null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor for this class which sets this class's instance variables to
	 * the ones passed from Input class and creates the frame.
	 * 
	 * // fromIn = from Input class
	 * @param fromInFname
	 * @param fromInLname
	 * @param fromInAcctN
	 * @param fromInBalance
	 * 
	 * @throws SQLException
	 */
	public Output(String fromInFname, String fromInLname, int fromInAcctN, double fromInBalance) throws SQLException {

		// initialize the instance variables
		this.firstname = fromInFname;
		this.lastname = fromInLname;
		this.accountNum = fromInAcctN;
		this.balance = fromInBalance;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250); // First two (x, y) = location.
										// Second two (x, y) = size.
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Options Menu"); // we no longer have access to the frame
										// from Input class that's why we have
										// to set title this way

		JLabel lblHi = new JLabel("Hi, " + firstname + " " + lastname);
		lblHi.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblHi.setBounds(5, 5, 198, 16);
		contentPane.add(lblHi);

		JLabel lblAccountId = new JLabel("Account ID: " + accountNum);
		lblAccountId.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblAccountId.setBounds(6, 29, 198, 16);
		contentPane.add(lblAccountId);

		JLabel lblTodaysBeginningBalance = new JLabel("Today's Beginning Balance: $" + balance);
		lblTodaysBeginningBalance.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblTodaysBeginningBalance.setBounds(5, 57, 357, 16);
		contentPane.add(lblTodaysBeginningBalance);

		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		btnDeposit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Deposit depositWindow;
				try {
					// pass this class's balance to be used in Deposit class
					depositWindow = new Deposit(balance);
					depositWindow.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		btnDeposit.setBounds(60, 102, 117, 29);
		contentPane.add(btnDeposit);

		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		btnWithdraw.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// pass this class's balance to be used in Withdraw class
				Withdraw withdrawWindow = new Withdraw(balance);
				withdrawWindow.setVisible(true);
				
				// close this class's window
				dispose();

			}

		});
		btnWithdraw.setBounds(226, 102, 117, 29);
		contentPane.add(btnWithdraw);

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		btnExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// pass this class's balance to be used in Exit class
				Exit exitWindow = new Exit(balance);
				exitWindow.setVisible(true);
				
				// close this class's window
				dispose();

			}

		});
		btnExit.setBounds(141, 147, 117, 29);
		contentPane.add(btnExit);

		JLabel lblNewLabel = new JLabel("For assistance call 1-800-902-8108");
		lblNewLabel.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblNewLabel.setBounds(67, 190, 272, 16);
		contentPane.add(lblNewLabel);

	}

}