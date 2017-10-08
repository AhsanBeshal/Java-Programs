
/**
 * This project should be launched from Input class first!!!
 * 
 * This project represents UPS's delivery system. When it is launched it will ask the user/driver for 3 inputs. First the 
 * city the driver is currently in, then it will ask for his location (x and y). After that those inputs will be used in 
 * Results class to figure out nearest delivery depending on driver's input. There will be 3 time frames. 5 min, 10 min and
 * 15 min, if the delivery is within those time frames then it will show the receiver's information along with the time frame.
 * 
 * @author (Ahsan Beshal)
 * Date: 06/27/2017 
 * 
 */

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Input {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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

	/**
	 * Create the application.
	 */
	public Input() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("UPS");

		JLabel UPS_logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/ups-logo.png")).getImage();
		UPS_logo.setIcon(new ImageIcon(img));
		UPS_logo.setBounds(6, 45, 197, 194);
		frame.getContentPane().add(UPS_logo);

		JLabel lblEnterYour = new JLabel("Enter your current location");
		lblEnterYour.setFont(new Font("Courier", Font.PLAIN, 13));
		lblEnterYour.setBounds(202, 45, 258, 16);
		frame.getContentPane().add(lblEnterYour);

		JLabel lblBoxesBelow = new JLabel("in the boxes below");
		lblBoxesBelow.setFont(new Font("Courier", Font.PLAIN, 13));
		lblBoxesBelow.setBounds(202, 68, 152, 16);
		frame.getContentPane().add(lblBoxesBelow);

		JLabel lblCityName = new JLabel("City");
		lblCityName.setFont(new Font("Courier", Font.PLAIN, 13));
		lblCityName.setBounds(202, 100, 33, 16);
		frame.getContentPane().add(lblCityName);

		textField = new JTextField();
		textField.setFont(new Font("Courier", Font.PLAIN, 13));
		textField.setBounds(236, 96, 98, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Courier", Font.PLAIN, 13));
		lblX.setBounds(227, 131, 8, 17);
		frame.getContentPane().add(lblX);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Courier", Font.PLAIN, 13));
		textField_1.setBounds(236, 126, 98, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Y");
		lblNewLabel.setFont(new Font("Courier", Font.PLAIN, 13));
		lblNewLabel.setBounds(227, 161, 8, 17);
		frame.getContentPane().add(lblNewLabel);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Courier", Font.PLAIN, 13));
		textField_2.setBounds(236, 156, 98, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setFont(new Font("Courier", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					storeInput();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		btnNewButton.setBounds(236, 186, 98, 32);
		frame.getContentPane().add(btnNewButton);

	}

	/**
	 * This method will get the inputs from the textfields and store them in
	 * local variables. It will first check input for the city, if the first
	 * letter contains a lowercase then it will break out of the loop and show
	 * error message if not it will check x and y inputs, if it contains
	 * anything except for a valid number it will show error message, otherwise
	 * it will call the Results class.
	 *
	 * @throws SQLException
	 * 
	 */
	public void storeInput() throws SQLException {
		boolean loopStopper = true; // set it true at start

		while (loopStopper == true) {

			// check if first letter is lowercase, if it is then break
			if (Character.isLowerCase(textField.getText().charAt(0))) {
				JOptionPane.showMessageDialog(null, "First Letter Lowercase!");
				break;
			} else {

				// this will store driver's city input
				String driverCityInput = textField.getText();

				// these two variables will store the converted inputs for x and y
				int convDriverLocX;
				int convDriverLocY;

				try {
					// convert
					convDriverLocX = Integer.parseInt(textField_1.getText());
					convDriverLocY = Integer.parseInt(textField_2.getText());

					// if anything except valid numbers entered, then it will
					// show error message and break out of the loop
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Wrong Input! Check X or Y");
					break;
				}

				// pass the inputs to other class to be used there
				Results results = new Results(driverCityInput, convDriverLocX, convDriverLocY);
				results.setVisible(true);
				frame.dispose();

				// set it to false to stop loop
				loopStopper = false;
			}
		}
	}
}
