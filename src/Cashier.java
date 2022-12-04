import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cashier extends JPanel {

	JTextField idField;
	JTextField userField;
	JButton btnAddCashier;
	JButton btnDeleteCashier;
	JButton btnUpdateProduct;
	private JPasswordField passwordField;
	private JLabel error;
	String error_message = "Enter username and passowrd";
	String user_addCashier, pass_addCashier;
	String user_deleteCashier, pass_deleteCashier, err_deleteCashier = "Enter username and password";
	String id_searchCashier, err_searchCashier = "Enter product id!";

	public static void addCashier() {
		// new func
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel lblAddCashier = new JLabel("ADD CASHIER");
		lblAddCashier.setBounds(328, 45, 182, 21);
		lblAddCashier.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblAddCashier);

		// new func
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(246, 104, 124, 21);
		add(lblUserName);

		// new func
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(246, 136, 124, 21);
		add(lblPassword);

		// new func
		userField = new JTextField();
		userField.setBounds(436, 106, 147, 20);
		add(userField);
		userField.setColumns(10);

		// new func
		btnAddCashier = new JButton("Add Cashier");
		btnAddCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_addCashier = userField.getText().trim();
				pass_addCashier = passwordField.getText().toString().trim().toLowerCase();
				if (user_addCashier.equals("") || pass_addCashier.equals(""))
					error.setText(error_message);
				else {
					error.setText("");
					DB.addCashier(user_addCashier, pass_addCashier);
					userField.setText("");
					passwordField.setText("");
				}
			}
		});
		btnAddCashier.setBounds(436, 194, 147, 23);
		add(btnAddCashier);

		passwordField = new JPasswordField();
		passwordField.setBounds(436, 138, 147, 19);
		add(passwordField);

		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(328, 241, 201, 14);
		add(error);

	}

	public static void deleteCashier() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel lblDeleteCashier = new JLabel("DELETE CASHIER");
		lblDeleteCashier.setBounds(328, 45, 182, 21);
		lblDeleteCashier.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblDeleteCashier);

		JLabel lblUserName = new JLabel("User name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(246, 104, 124, 21);
		add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(246, 136, 124, 21);
		add(lblPassword);

		userField = new JTextField();
		userField.setBounds(449, 106, 136, 20);
		add(userField);
		userField.setColumns(10);

		btnDeleteCashier = new JButton("Delete Cashier");
		btnDeleteCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_deleteCashier = userField.getText().trim();
				pass_deleteCashier = passwordField.getText().trim().toLowerCase();
				if (user_deleteCashier.equals("") || pass_deleteCashier.equals(""))
					error.setText(err_deleteCashier);
				else {
					error.setText("");
					DB.deleteCashier(user_deleteCashier, pass_deleteCashier);
					userField.setText("");
					passwordField.setText("");
				}
			}
		});
		btnDeleteCashier.setBounds(449, 194, 136, 23);
		add(btnDeleteCashier);

		passwordField = new JPasswordField();
		passwordField.setBounds(449, 138, 136, 19);
		add(passwordField);

		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(277, 247, 248, 14);
		add(error);

	}

	public static void searchCashier() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel lblsearch = new JLabel("SEARCH CASHIER");
		lblsearch.setBounds(319, 84, 182, 21);
		lblsearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblsearch);

		JLabel lbluser = new JLabel("User name");
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbluser.setBounds(253, 156, 124, 21);
		add(lbluser);

		idField = new JTextField();
		idField.setBounds(449, 158, 136, 20);
		add(idField);
		idField.setColumns(10);

		btnUpdateProduct = new JButton("Search");
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (idField.getText().equals("")) {
					error.setText(err_searchCashier);
				} else {
					error.setText("");
					id_searchCashier = idField.getText().trim();
					DB.searchCashier(id_searchCashier);
					idField.setText("");
				}
			}
		});
		btnUpdateProduct.setBounds(449, 219, 136, 23);
		add(btnUpdateProduct);

		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(349, 277, 217, 14);
		add(error);

	}

}
