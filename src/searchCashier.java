import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchCashier extends JPanel {
	
	JTextField field_id;
	JButton btnUpdateProduct;
	private JLabel error;
	String id,error_message="Enter product id!";
	/**
	 * Create the panel.
	 */
	public searchCashier() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel search_label = new JLabel("SEARCH CASHIER");
		search_label.setBounds(319, 84, 182, 21);
		search_label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(search_label);
		
		JLabel user_label = new JLabel("User name");
		user_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		user_label.setBounds(253, 156, 124, 21);
		add(user_label);
		
		field_id = new JTextField();
		field_id.setBounds(449, 158, 136, 20);
		add(field_id);
		field_id.setColumns(10);
		
		btnUpdateProduct = new JButton("Search");
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!field_id.getText().equals(""))
				{
					error.setText("");
					id=field_id.getText().trim();
					DB.searchCashier(id);
					field_id.setText("");
				}
				else
				{
					error.setText(error_message);
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
