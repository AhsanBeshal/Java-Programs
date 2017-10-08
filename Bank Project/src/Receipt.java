
/**
 * This class will be printing out the receipt after the user has either deposited or withdrew from their balance. It will
 * take one parameter from Output class and depending on whether the user chose deposit or withdraw it will pass one 
 * updated parameter from either class and will be used here to print.
 * 
 * 
 * @author (Ahsan Beshal)
 * Date: 06/13/2017 
 * 
 */

import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.util.Date;

public class Receipt extends JFrame {

	private JPanel contentPane;

	private double amount; // this class's amount deposited or withdrawn from
							// Deposit or Withdraw class, to set it to amount
							// from Deposit or Withdraw class or Exit class

	private double balance; // this class's balance, to set it to balance
							// from Deposit class or Withdraw class
							// or Exit class

	private String msg; // this class's msg, to set it to msg from Deposit or
						// from Withdraw class or Exit class

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt frame = new Receipt((Double) null, (Double) null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor for this class which sets this class's amount, balance and
	 * msg to Deposit or Withdraw or Exit class's parameter and creates the
	 * frame.
	 * 
	 * // parameter from Deposit or Withdraw or Exit class
	 * @param amount
	 * @param balance
	 * @param msg
	 * 
	 * @throws SQLException
	 */
	public Receipt(double amount, double balance, String msg) throws SQLException {
		this.amount = amount;
		this.balance = balance;
		this.msg = msg;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Receipt");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy                              HH:mm:ss");
		Date date = new Date();

		JLabel lblNewLabel = new JLabel(dateFormat.format(date));
		lblNewLabel.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 6, 388, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(msg + amount);
		lblNewLabel_1.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(6, 40, 261, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Your current balance: $" + balance + "");
		lblNewLabel_2.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(6, 74, 333, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Thank You for using United Bank.");
		lblNewLabel_3.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(6, 108, 372, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("For assistance call 1-800-902-8108");
		lblNewLabel_4.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(67, 190, 272, 16);
		contentPane.add(lblNewLabel_4);

	}

}
