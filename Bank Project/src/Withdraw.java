
/**
 * This class will give the user multiple quick preset options to withdraw money from their balance. It will take 
 * one parameter from the Output class which is the balance and minus different amounts of money to that balance 
 * depending on the user.
 * 
 * 
 * @author (Ahsan Beshal) 
 * Date: 06/13/2017
 * 
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Withdraw extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private double amount; // this will hold the amount withdrawn

	private String msg = "You have withdrawn: $"; // this will be the message to
													// be passed to Receipt
													// class, to be used there

	private double balance; // this class's balance, to set it to balance from
							// Output class

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw frame = new Withdraw((Double) null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor for this class which sets this class's balance to the one
	 * passed from Output class and creates the frame.
	 * 
	 * @param fromOutputbalance
	 */
	public Withdraw(double fromOutputBalance) {
		this.balance = fromOutputBalance; // initialize

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Withdraw Options");

		JToggleButton toggleButton = new JToggleButton("$5");
		toggleButton.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		toggleButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				amount = 5;
				balance -= amount;

				Receipt receipt;
				try {
					// pass amount and msg to Receipt class and
					// pass this class's balance to Receipt class
					receipt = new Receipt(amount, balance, msg);
					// open Receipt class's window
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		
		toggleButton.setBounds(6, 6, 111, 29);
		contentPane.add(toggleButton);

		JToggleButton toggleButton_1 = new JToggleButton("$10");
		toggleButton_1.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		toggleButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				amount = 10;
				balance -= amount;

				Receipt receipt;
				try {
					receipt = new Receipt(amount, balance, msg);
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		
		toggleButton_1.setBounds(6, 43, 111, 29);
		contentPane.add(toggleButton_1);

		JToggleButton toggleButton_2 = new JToggleButton("$25");
		toggleButton_2.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		toggleButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				amount = 25;
				balance -= amount;

				Receipt receipt;
				try {
					receipt = new Receipt(amount, balance, msg);
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		
		toggleButton_2.setBounds(6, 80, 111, 29);
		contentPane.add(toggleButton_2);

		JToggleButton toggleButton_3 = new JToggleButton("$50");
		toggleButton_3.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		toggleButton_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				amount = 50;
				balance -= amount;

				Receipt receipt;
				try {
					receipt = new Receipt(amount, balance, msg);
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		
		toggleButton_3.setBounds(6, 116, 111, 29);
		contentPane.add(toggleButton_3);

		JToggleButton toggleButton_4 = new JToggleButton("$100");
		toggleButton_4.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		toggleButton_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				amount = 100;
				balance -= amount;

				Receipt receipt;
				try {
					receipt = new Receipt(amount, balance, msg);
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		
		toggleButton_4.setBounds(6, 152, 111, 29);
		contentPane.add(toggleButton_4);

		JToggleButton toggleButton_5 = new JToggleButton("$200");
		toggleButton_5.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		toggleButton_5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				amount = 200;
				balance -= amount;

				Receipt receipt;
				try {
					receipt = new Receipt(amount, balance, msg);
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		
		toggleButton_5.setBounds(283, 6, 111, 29);
		contentPane.add(toggleButton_5);

		JToggleButton toggleButton_6 = new JToggleButton("$300");
		toggleButton_6.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		toggleButton_6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				amount = 300;
				balance -= amount;

				Receipt receipt;
				try {
					receipt = new Receipt(amount, balance, msg);
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		
		toggleButton_6.setBounds(283, 43, 111, 29);
		contentPane.add(toggleButton_6);

		JToggleButton toggleButton_7 = new JToggleButton("$400");
		toggleButton_7.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		toggleButton_7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				amount = 400;
				balance -= amount;

				Receipt receipt;
				try {
					receipt = new Receipt(amount, balance, msg);
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();
				
			}

		});
		
		toggleButton_7.setBounds(283, 80, 111, 29);
		contentPane.add(toggleButton_7);

		JToggleButton toggleButton_8 = new JToggleButton("$500");
		toggleButton_8.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		toggleButton_8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				amount = 500;
				balance -= amount;

				Receipt receipt;
				try {
					receipt = new Receipt(amount, balance, msg);
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		
		toggleButton_8.setBounds(283, 116, 111, 29);
		contentPane.add(toggleButton_8);

		JToggleButton toggleButton_9 = new JToggleButton("$1000");
		toggleButton_9.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		toggleButton_9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				amount = 1000;
				balance -= amount;

				Receipt receipt;
				try {
					receipt = new Receipt(amount, balance, msg);
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		
		toggleButton_9.setBounds(283, 152, 111, 29);
		contentPane.add(toggleButton_9);

		textField = new JTextField();
		textField.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		textField.setBounds(142, 55, 117, 37);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblOrEnterA = new JLabel("Custom Amount");
		lblOrEnterA.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblOrEnterA.setBounds(149, 23, 116, 26);
		contentPane.add(lblOrEnterA);

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// get the user input from the text field
				String stringInput = textField.getText();
				// convert that user input to double
				amount = Double.parseDouble(stringInput);
				// add to converted input
				balance -= amount;

				Receipt receipt;
				try {
					receipt = new Receipt(amount, balance, msg);
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		
		btnNewButton.setBounds(142, 108, 117, 71);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("For assistance call 1-800-902-8108");
		lblNewLabel.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblNewLabel.setBounds(67, 193, 272, 16);
		contentPane.add(lblNewLabel);
	}
}