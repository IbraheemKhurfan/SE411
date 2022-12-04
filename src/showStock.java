import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class showStock extends JPanel {
	private JTable stockTable;
	JComboBox<String> companyBox;
	DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public showStock() {
		setLayout(null);
		setBounds(100, 100, 840, 619);
		JLabel stock_label = new JLabel("AVAILABLE STOCK");
		stock_label.setBounds(328, 26, 182, 21);
		stock_label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(stock_label);
		
		model = new DefaultTableModel(); 
		stockTable = new JTable(model);
		stockTable.setBounds(98, 112, 645, 397);
		add(stockTable);
		model.addColumn("Product ID");
		model.addColumn("Product Detail");
		model.addColumn("Company");
		model.addColumn("Quantity");
		JScrollPane scroll = new JScrollPane(stockTable);
		scroll.setBounds(98, 112, 645, 397);
		add(scroll);
		
		companyBox = new JComboBox<String>();
		companyBox.setBackground(Color.WHITE);
		companyBox.setBounds(583, 81, 160, 20);
		add(companyBox);
		companyBox.addItem("All");
		companyBox.addItem("General");
		companyBox.addItem("Mats & Rugs");
		companyBox.addItem("N/S & Electric");
		companyBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				updateTable();
			}
		});
		
		JLabel company_label = new JLabel("Company");
		company_label.setBounds(582, 68, 161, 14);
		add(company_label);
		
		JButton exportToExcel_Button = new JButton("Export to Excel");
		exportToExcel_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				toExcel(stockTable, new File("availableStock.xls"));
				JOptionPane.showMessageDialog(null, "Export file created");
			}
		});
		exportToExcel_Button.setBounds(605, 525, 138, 23);
		add(exportToExcel_Button);
		
		JButton refresh_Button = new JButton("Refresh");
		refresh_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateTable();
			}
		});
		refresh_Button.setBounds(457, 525, 138, 23);
		add(refresh_Button);
		updateTable();
		
	}
	
	public void updateTable()
	{
		model.setRowCount(0);
		ArrayList<String> stock=new ArrayList<String>();
		stock=DB.showStock(companyBox.getSelectedItem().toString());
		for(int index=0;index<stock.size();index+=4)
		{
			model.addRow(new Object[]{stock.get(index),stock.get(index+1),stock.get(index+2),stock.get(index+3)});
		}
	}
	

		public void toExcel(JTable table, File file){
		    try{
		        TableModel model = table.getModel();
		        FileWriter excel = new FileWriter(file);

		        for(int index = 0; index < model.getColumnCount(); index++){
		            excel.write(model.getColumnName(index) + "\t");
		        }

		        excel.write("\n");

		        for(int index=0; index< model.getRowCount(); index++) {
		            for(int j=0; j < model.getColumnCount(); j++) {
		                excel.write(model.getValueAt(index,j).toString()+"\t");
		            }
		            excel.write("\n");
		        }

		        excel.close();

		    }catch(IOException exception){ JOptionPane.showMessageDialog(null, exception); }
		}
}
