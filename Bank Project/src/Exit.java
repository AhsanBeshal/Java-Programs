
/**
 * This class will give the user option to see their receipt or exit. 
 * 
 * 
 * @author (Ahsan Beshal) 
 * Date: 06/13/2017
 * 
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Exit extends JFrame {

	private JPanel contentPane;

	private double balance; // this class's balance to set it to balance from
							// Output class to use it in receipt.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exit frame = new Exit((Double) null);
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
	public Exit(double fromOutputBalance) {
		this.balance = fromOutputBalance; // initialize

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Exit Options");

		JLabel lblWouldYouLike = new JLabel("Would you like a receipt?");
		lblWouldYouLike.setBounds(99, 64, 207, 15);
		lblWouldYouLike.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		contentPane.add(lblWouldYouLike);

		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String msg = "Deposited or Withdrawn: $"; // this class's msg
				
				double amount = 0.0; // this class's amount, set to 0.0 because
										// we don't have anything to pass and
										// Receipt class accepts amount
										// argument 

				try {
					// pass amount, balance and this class's msg
					Receipt receipt = new Receipt(amount, balance, msg);
					receipt.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// close this class's window
				dispose();

			}

		});
		
		btnYes.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		btnYes.setBounds(72, 107, 117, 29);
		contentPane.add(btnYes);

		JButton btnNewButton = new JButton("No");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}

		});
		
		btnNewButton.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		btnNewButton.setBounds(201, 107, 117, 29);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("For assistance call 1-800-902-8108");
		lblNewLabel.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		lblNewLabel.setBounds(67, 190, 272, 16);
		contentPane.add(lblNewLabel);

	}

}
