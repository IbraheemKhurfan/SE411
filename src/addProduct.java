import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField; 
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class addProduct extends JPanel {
	
	JTextField idField;
	JTextArea descriptionField;
    JTextField quantityField;
    JLabel error;
	JComboBox<String> company;
	String product_id,product_details,company;
	int quantity;
	String error_message="Enter product id and quantity";
	/**
	 * Create the panel.
	 */
	public addProduct() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel AddProduct_Label = new JLabel("ADD PRODUCT");
		AddProduct_Label.setBounds(328, 45, 115, 21);
		AddProduct_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(AddProduct_Label);
		
		JLabel ProductName_Label = new JLabel("Product ID");
		ProductName_Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ProductName_Label.setBounds(246, 136, 124, 21);
		add(ProductName_Label);
		
		JLabel ProductDescription_Label = new JLabel("Product Details\r\n");
		ProductDescription_Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ProductDescription_Label.setBounds(246, 168, 139, 21);
		add(ProductDescription_Label);
		
		idField = new JTextField();
		idField.setBounds(449, 137, 136, 20);
		add(idField);
		idField.setColumns(10);
		
		descriptionField = new JTextArea();
		descriptionField.setBounds(449, 168, 136, 58);
		add(descriptionField);
		JScrollPane scroll = new JScrollPane(descriptionField);
		scroll.setBounds(449, 168, 136, 58);
		add(scroll);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCompany.setBounds(246, 241, 124, 21);
		add(lblCompany);
		
		JButton AddProduct_Button = new JButton("Add Product");
		AddProduct_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!quantityField.getText().equals("")||!idField.getText().equals(""))
				{
					error.setText("");
					product_id=idField.getText().trim();
					quantity=Integer.parseInt(quantityField.getText().trim());
					product_details=descriptionField.getText().trim();
					company=company.getSelectedItem().toString();
					DB.addProductToDB(product_id, product_details, company, quantity);
					idField.setText("");
					quantityField.setText("");
					descriptionField.setText("");
				}
				else
				{
					error.setText(error_message);
					
				}
			}
		});
		AddProduct_Button.setBounds(449, 334, 136, 23);
		add(AddProduct_Button);
		
		quantityField = new JTextField();
		quantityField.setColumns(10);
		quantityField.setBounds(449, 274, 136, 20);
		add(quantityField);
		
		JLabel Quantity_Label  = new JLabel("Items available");
		Quantity_Label .setFont(new Font("Tahoma", Font.PLAIN, 14));
		Quantity_Label .setBounds(246, 273, 124, 21);
		add(Quantity_Label );
		
		company = new JComboBox<String>();
		company.setBounds(449, 243, 136, 20);
		add(company);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(339, 92, 265, 14);
		add(error);
		company.addItem("General");
		company.addItem("Mats & Rugs");
		company.addItem("N/S & Electric");
		
	}
}
