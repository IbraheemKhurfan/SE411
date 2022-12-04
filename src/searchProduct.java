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

public class searchProduct extends JPanel {
	
	JTextField idField;
	JButton Search_Button;
	private JLabel error;
	String id,error_message="Enter product id!";
	/**
	 * Create the panel.
	 */
	public searchProduct() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel SearchProduct_Label = new JLabel("SEARCH PRODUCT");
		SearchProduct_Label.setBounds(319, 84, 182, 21);
		SearchProduct_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(SearchProduct_Label);
		
		JLabel SearchProduct_Label = new JLabel("Product ID");
		SearchProduct_Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SearchProduct_Label.setBounds(253, 156, 124, 21);
		add(SearchProduct_Label);
		
		idField = new JTextField();
		idField.setBounds(449, 158, 136, 20);
		add(idField);
		idField.setColumns(10);
		
		Search_Button = new JButton("Search");
		Search_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exception) {
				
				if(!idField.getText().equals(""))
				{
					error.setText("");
					id=idField.getText().trim();
					DB.searchProduct(id);
					idField.setText("");
				}
				else
				{
					error.setText(error_message);
				}
			}
		});
		Search_Button.setBounds(449, 219, 136, 23);
		add(Search_Button);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(349, 277, 217, 14);
		add(error);
		
	}

}
