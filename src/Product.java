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

public class Product extends JPanel {

	JTextField idField;
	JTextField field_id;
	JTextArea descriptionField;
	JTextField quantityField;
	JButton updateProduct_Button;
	JButton btnDeleteProduct;
	JButton Search_Button;
	JLabel error;
	JComboBox<String> company_box;
	String product_id, product_details, company;
	int quantity;
	String error_message = "Enter product id and quantity";
	String id_searchProduct, error_message_searchProduct = "Enter product id!";
	String id_deleteProduct, err_deleteProduct = "Enter product id!";
	String id_updateProduct, detail_updateProduct, company_updateProduct;
	String err_updateProduct = "Enter product id and quantity";

	/**
	 * Create the panel.
	 */

	public Font make_font(String name, int size) {
		return new Font(name, Font.PLAIN, size);
	}

	public void settting_add(int x, int y, int width, int height, String text) {

		// setBounds(x,y, width, height);
		JLabel AddProduct_Label = new JLabel(text);
		AddProduct_Label.setBounds(x, y, width, height);
		Font new_font = make_font("Tahoma", 21);
		AddProduct_Label.setFont(new_font);
		add(AddProduct_Label);

	}

	public void addProduct() {
		setLayout(null);

		setBounds(100, 100, 840, 619);

		settting_add(328, 45, 115, 21, "ADD PRODUCT");
		// JLabel lblAddProduct = new JLabel("ADD PRODUCT");
		// lblAddProduct.setBounds(328, 45, 115, 21);
		// lblAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 17));
		// add(lblAddProduct);

		settting_add(246, 136, 124, 21, "Product ID");
		// JLabel lblProductName = new JLabel("Product ID");
		// lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// add(lblProductName);

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
				if (!quantityField.getText().equals("") || !idField.getText().equals("")) {
					error.setText("");
					product_id = idField.getText().trim();
					quantity = Integer.parseInt(quantityField.getText().trim());
					product_details = descriptionField.getText().trim();
					company = company.getSelectedItem().toString();
					DB.addProductToDB(product_id, product_details, company, quantity);
					idField.setText("");
					quantityField.setText("");
					descriptionField.setText("");
				} else {
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

		JLabel Quantity_Label = new JLabel("Items available");
		Quantity_Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Quantity_Label.setBounds(246, 273, 124, 21);
		add(Quantity_Label);

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

	public void searchProduct() {
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

				if (!idField.getText().equals("")) {
					error.setText("");
					id_searchProduct = idField.getText().trim();
					DB.searchProduct(id_searchProduct);
					idField.setText("");
				} else {
					error.setText(error_message_searchProduct);
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

	public void deleteProduct() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel lblUpdateProduct = new JLabel("DELETE PRODUCT");
		lblUpdateProduct.setBounds(319, 84, 182, 21);
		lblUpdateProduct.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblUpdateProduct);

		JLabel lblProductName = new JLabel("Product ID");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductName.setBounds(253, 156, 124, 21);
		add(lblProductName);

		idField = new JTextField();
		idField.setBounds(449, 158, 136, 20);
		add(idField);
		idField.setColumns(10);

		btnDeleteProduct = new JButton("Delete Product");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (idField.getText().equals("")) {
					error.setText(err);
				} else {
					error.setText("");
					id = idField.getText().trim();
					DB.deleteProductToDB(id);
					idField.setText("");
				}
			}
		});
		btnDeleteProduct.setBounds(449, 219, 136, 23);
		add(btnDeleteProduct);

		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(349, 277, 217, 14);
		add(error);

	}

	public void updateProduct() {
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

		descriptionField = new JTextArea();
		descriptionField.setBounds(449, 168, 136, 58);
		add(descriptionField);
		JScrollPane scroll = new JScrollPane(descriptionField);
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
				id = field_id.getText().trim() + e.getKeyChar();
				ArrayList<String> data = DB.searchP(id);
				if (data.size() == 3) {
					descriptionField.setText(data.get(0));
					quantityField.setText(data.get(2));
					switch (data.get(1)) {
						case "General":
							company_box.setSelectedIndex(0);
							break;
						case "Mats & Rugs":
							company_box.setSelectedIndex(1);
							break;
						case "N/S & Electric":
							company_box.setSelectedIndex(2);
							break;
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
				if (!quantityField.getText().equals("") || !field_id.getText().equals("")) {
					error.setText("");
					id_updateProduct = field_id.getText().trim();
					quantity = Integer.parseInt(quantityField.getText().trim());
					detail_updateProduct = descriptionField.getText().trim();
					company = company_box.getSelectedItem().toString();
					DB.updateProductToDB(id_updateProduct, detail_updateProduct, company_updateProduct, quantity);
					field_id.setText("");
					quantityField.setText("");
					descriptionField.setText("");
				} else {
					error.setText(err_updateProduct);

				}
			}
		});
		updateProduct_Button.setBounds(449, 338, 136, 23);
		add(updateProduct_Button);

		quantityField = new JTextField();
		quantityField.setColumns(10);
		quantityField.setBounds(449, 278, 136, 20);
		add(quantityField);

		JLabel quantity_label = new JLabel("Items available");
		quantity_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantity_label.setBounds(246, 276, 124, 21);
		add(quantity_label);

		company_box = new JComboBox<String>();
		company_box.setBounds(449, 243, 136, 20);
		add(company_box);

		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(299, 95, 286, 14);
		add(error);
		company_box.addItem("General");
		company_box.addItem("Mats & Rugs");
		company_box.addItem("N/S & Electric");

	}

}
