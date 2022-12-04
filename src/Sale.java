import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Sale extends JPanel {
	private JTable sale;
	private JTextField date;
	JComboBox<String> company_box ;
	String company,date;
	static DefaultTableModel defaultTableModel;
	ArrayList<String> print=new ArrayList<String>();
	/**
	 * Create the panel.
	 */
	public Sale() {
		setLayout(null);
		
		String [] header={"Date","Product ID","Company","Sale"};
		defaultTableModel= new DefaultTableModel(header, 0);  
		sale = new JTable(defaultTableModel);
		sale.setBounds(244, 69, 494, 379);
		add(sale);
		JScrollPane scrollPane=new JScrollPane(sale);
		scrollPane.setBounds(244, 69, 494, 379);
		add(scrollPane);
		
		JButton Print_Button = new JButton("PRINT");
		Print_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exception) {
				
				Object data[]=new Object[defaultTableModel.getColumnCount()*defaultTableModel.getRowCount()];
				int index=0;
				long total=0;
				for(int row=0;row<defaultTableModel.getRowCount();row++)
				{
					for(int col=0;col<defaultTableModel.getColumnCount();col++)
					{
						data[index]=sale.getValueAt(row, col);
						if(col==3)
							{total+=Long.parseLong((String) data[index]);}
						index++;
					}
				}
				pdfGenerator.makePdf2(data,total);
			}
		});
		Print_Button.setBounds(244, 472, 118, 46);
		add(Print_Button);
		
		JRadioButton dailySale = new JRadioButton("Daily Sale");
		dailySale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dailySale.setBounds(62, 69, 109, 23);
		add(dailySale);
		dailySale.setSelected(true);
		
		JRadioButton monthlySale = new JRadioButton("Monthly Sale");
		monthlySale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		monthlySale.setBounds(62, 112, 144, 23);
		add(monthlySale);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(62, 178, 75, 14);
		add(lblDate);
		
		date = new JTextField();
		date.setBounds(62, 199, 86, 20);
		add(date);
		date.setColumns(10);
		
		JLabel lblMm = new JLabel("yyyy/mm/dd");
		lblMm.setBounds(149, 202, 85, 14);
		add(lblMm);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exception) {
				date=date.getText().trim();
				company=company_box.getSelectedItem().toString();
				if(dailySale.isSelected())
					dailySale(date,company);
				else
					monthlySale(date,company);
			}
		});
		btnLoad.setBounds(62, 328, 89, 23);
		add(btnLoad);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCompany.setBounds(62, 230, 109, 27);
		add(lblCompany);
		
		company_box = new JComboBox<String>();
		company_box.setBounds(62, 261, 86, 20);
		add(company_box);
		company_box.addItem("All");
		company_box.addItem("General");
		company_box.addItem("Mats & Rugs");
		company_box.addItem("N/S & Electric");
		
		
		
		monthlySale.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dailySale.setSelected(false);
			}
		});
		dailySale.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent exception) {
		// TODO Auto-generated method stub
				monthlySale.setSelected(false);
			}
		});
	}
	
	public static void dailySale(String date,String company)
	{
		ArrayList<String> sl=new ArrayList<String>();
		sl=DB.getSale(date, company);
		String x1,x2,x3,x4;
		defaultTableModel.setRowCount(0);
		int sz=sl.size()/4;
		for(int x=0;x<sz;x++)
		{
			x1=sl.get(0);sl.remove(0);
			x2=sl.get(0);sl.remove(0);
			x3=sl.get(0);sl.remove(0);
			x4=sl.get(0);sl.remove(0);
			
			defaultTableModel.addRow(new Object[]{x1,x2,x3,x4});
		}
	}
	public static void monthlySale(String date,String company)
	{
		String date[]=date.split("/");
		String s[]={"","01","02","03","04","05","06","07","08","09",
					"10","11","12","13","14","15","16","17","18","19",
					"20","21","22","23","24","25","26","27","28","29","30","31"};
		ArrayList<String> sl=new ArrayList<String>();
		String ndt;
		defaultTableModel.setRowCount(0);
		for(int x=1;x<=31;x++)
		{
			ndt=date_form(date,s,x);
			// 
			sl=DB.getSale(ndt, company);
			String x1,x2,x3,x4;
			
			int sz=sl.size()/4;
			for(int i=0;i<sz;i++)
			{
				x1=sl.get(0);sl.remove(0);
				x2=sl.get(0);sl.remove(0);
				x3=sl.get(0);sl.remove(0);
				x4=sl.get(0);sl.remove(0);
				
				defaultTableModel.addRow(new Object[]{x1,x2,x3,x4});
			}
		}
		
		
		
	}
	// make the string of date 
	private static String date_form(String[] date,String[] date_list,int place){
		return date[0]+"/"+date[1]+"/"+date_list[place].trim();

	}

	
}
