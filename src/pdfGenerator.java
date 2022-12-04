import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.html.table.Table;

public class pdfGenerator {

	public static void makePdf(Object[] data,long total,int inv)
	{
		String invoice="_invoice_.pdf";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		Document document = new Document();
	     
	         PdfWriter writer;
		
				try {
					writer = PdfWriter.getInstance(document, new FileOutputStream(invoice));
				
			
	         document.open();
	        Font font1 = new Font(Font.FontFamily.UNDEFINED, 18, Font.BOLD);
	        Paragraph paragraph1= new Paragraph("CADDEY STORE",font1);
	    
	        Paragraph paragraph2= new Paragraph("Main Market Gulberg II Lahore");
	        Paragraph paragraph3= new Paragraph("042-35712296\n\n\n");
	        Paragraph paragraph4= new Paragraph("\n\nGrand Total: "+total,font1);
	        Paragraph paragraph5= new Paragraph("\nThank you for visiting us�!!\nReturn/Exchange not possible with-out bill.");
	        
	         paragraph1.setAlignment(Element.ALIGN_CENTER);
	         paragraph3.setAlignment(Element.ALIGN_CENTER);
	         paragraph2.setAlignment(Element.ALIGN_CENTER);
	         document.add(paragraph1);
	         document.add(paragraph2);
	         document.add(paragraph3);
	         Font font2 = new Font(Font.FontFamily.UNDEFINED, 8, Font.NORMAL);
	         Phrase phrase = new Phrase("Time/Date: "+dateFormat.format(date), font2);
	         PdfContentByte canvas1 = writer.getDirectContent();
	         ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phrase, 40, 740, 0);
	         Phrase Invoice_Number = new Phrase("Invoice No. "+inv, font2);
	         PdfContentByte canvas2 = writer.getDirectContent();
	         ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, Invoice_Number, 510, 785, 0);
	         Image image;
			try {
				  image = Image.getInstance("E:\\XAMPP\\htdocs\\logo.png");
		          image.setAbsolutePosition(10f, 730f);
		          document.add(image);
		          
			} catch (MalformedURLException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			} catch (IOException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			
			 PdfPTable table = new PdfPTable(5);
			 float[] columnWidths = new float[] {15f, 30f, 10f, 10f,15f};
			 table.setWidths(columnWidths);
			 table.addCell("Product ID");
			 
			 table.addCell("Item Detail");
			 table.addCell("Unit Price");
			 table.addCell("Quantity");
			 table.addCell("Total Price");
		        for(int aw = 0; aw < data.length; aw++){
		            table.addCell(data[aw]+"");
		        }
		        document.add(table);
		        document.add(paragraph4);
		        document.add(paragraph5);
	        // writer.close();
	         document.close();
	         sendIn2printer(invoice);
				} catch (FileNotFoundException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				} catch (DocumentException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
	}
	public static void makePdf2(Object[] data,long total)
	{
		String sale="_sale_.pdf";
		Document document = new Document();
	     
	         PdfWriter writer;
		
				try {
					writer = PdfWriter.getInstance(document, new FileOutputStream(sale));
				
			
	         document.open();
	         Font font1 = new Font(Font.FontFamily.UNDEFINED, 18, Font.BOLD);
	        Paragraph paragraph1= new Paragraph("CADDEY STORE",font1);
	    
	        Paragraph paragraph2= new Paragraph("Main Market Gulberg II Lahore");
	        Paragraph paragraph3= new Paragraph("042-35712296\n\n\n");
	        Paragraph paragraph4= new Paragraph("\n\nGrand Total: "+total,font1);
	        
	         paragraph1.setAlignment(Element.ALIGN_CENTER);
	         paragraph3.setAlignment(Element.ALIGN_CENTER);
	         paragraph2.setAlignment(Element.ALIGN_CENTER);
	         document.add(paragraph1);
	         document.add(paragraph2);
	         document.add(paragraph3);
	       
			 PdfPTable table = new PdfPTable(4);
			 table.addCell("Date");
			 table.addCell("Product ID");
			 table.addCell("Company");
			 table.addCell("Sale");
			    for(int aw = 0; aw < data.length; aw++){
		            table.addCell(data[aw]+"");
		        }
		        document.add(table);
		        document.add(paragraph4);
		        
	        // writer.close();
	         document.close();
	         sendIn2printer(sale);
				} catch (FileNotFoundException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				} catch (DocumentException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
	}
	
	public static void sendIn2printer(String file)
	{ //The desktop api can help calling other applications in our machine
	    //and also many other features...
	    Desktop desktop = Desktop.getDesktop();
	    try {
	    //desktop.print(new File("DocXfile.docx"));
	        desktop.print(new File(file));
	    } catch (IOException exception) {           
	        exception.printStackTrace();
	    }}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
}
