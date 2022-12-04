import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class updateProduct extends JPanel {
	
	JTextField field_id;
	JTextArea description_field;
	JButton updateProduct_Button;
	JComboBox<String> companyBox;
	private JTextField quantity_field;
	JLabel error ;
	String id,detail,company;
	int quantity ;
	String err="Enter product id and quantity";
	/**
	 * Create the panel.
	 */
	public updateProduct() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel updateProduct_label = new JLabel("UPDATE PRODUCT");
		updateProduct_label.setBounds(328, 45, 182, 21);
		updateProduct_label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(updateProduct_label);
		
		JLabel productName_label = new JLabel("Product ID");
		productName_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		productName_label.setBounds(246, 136, 124, 21);
		add(productName_label);
		
		JLabel productDescription_label = new JLabel("Product detail\r\n");
		productDescription_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		productDescription_label.setBounds(246, 168, 139, 21);
		add(productDescription_label);
		
		field_id = new JTextField();
		field_id.setBounds(449, 137, 136, 20);
		add(field_id);
		field_id.setColumns(10);
		
		description_field = new JTextArea();
		description_field.setBounds(449, 168, 136, 58);
		add(description_field);
		JScrollPane scroll = new JScrollPane(description_field);
		scroll.setBounds(449, 168, 136, 58);
		add(scroll);
		
		JLabel company_label = new JLabel("Company");
		company_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		company_label.setBounds(246, 241, 124, 21);
		add(company_label);
		field_id.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				id=field_id.getText().trim()+e.getKeyChar();
				ArrayList<String> data=DB.searchP(id);
				if(data.size()==3)
					{
						description_field.setText(data.get(0));
						quantity_field.setText(data.get(2));
						switch(data.get(1))
						{
							case "General":companyBox.setSelectedIndex(0);break;
							case "Mats & Rugs":companyBox.setSelectedIndex(1);break;
							case "N/S & Electric":companyBox.setSelectedIndex(2);break;
						}
					}
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		updateProduct_Button = new JButton("Update Product");
		updateProduct_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!quantity_field.getText().equals("")||!field_id.getText().equals(""))
				{
					error.setText("");
					id=field_id.getText().trim();
					quantity =Integer.parseInt(quantity_field.getText().trim());
					detail=description_field.getText().trim();
					company=companyBox.getSelectedItem().toString();
					DB.updateProductToDB(id, detail, company, quantity );
					field_id.setText("");
					quantity_field.setText("");
					description_field.setText("");
				}
				else
				{
					error.setText(err);

					
				}
			}
		});
		updateProduct_Button.setBounds(449, 338, 136, 23);
		add(updateProduct_Button);
		
		quantity_field = new JTextField();
		quantity_field.setColumns(10);
		quantity_field.setBounds(449, 278, 136, 20);
		add(quantity_field);
		
		JLabel quantity_label = new JLabel("Items available");
		quantity_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantity_label.setBounds(246, 276, 124, 21);
		add(quantity_label);
		
		companyBox = new JComboBox<String>();
		companyBox.setBounds(449, 243, 136, 20);
		add(companyBox);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(299, 95, 286, 14);
		add(error);
		companyBox.addItem("General");
		companyBox.addItem("Mats & Rugs");
		companyBox.addItem("N/S & Electric");
		
	}

}
