import java.io.FileNotFoundException;


import java.io.FileOutputStream;

import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;
public class CratePdf {
	float Gross_salary;
   void calculateSalary(String na,String age,String Enum,int sal,int id){
	 	float DA=20*sal/100;
	 	float TA=10*sal/100;
	 	int CCA=5000;
	 	float M_a=10*sal/100;
	 	float pf=5*sal/100;
	 	float gpf=5*sal/100;
	 	float lic=2*sal/100;
		
		Gross_salary=(20*sal/100)+(10*sal/100)+5000+(10*sal/100)+sal;
		Gross_salary=(Gross_salary-((5*sal/100)+(5*sal/100)+(2*sal/100)));
		
		
		
		Document doc = new Document();  
		try  
		{  
			String s1="D:\\"+na+"_"+id+".pdf";
		PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(s1));  
		System.out.println("PDF created.");  
		//opens the PDF  
		doc.open();  
		String mess=""+Gross_salary;
		doc.add(new Paragraph("Name-"+na+"                                           "+"Age-"+age+"                           "+"Mobile Number-"+Enum));
//		doc.add(new Paragraph(age));
//		doc.add(new Paragraph(Enum));  
		doc.add(new Paragraph("DA:"+DA));  
		doc.add(new Paragraph("TA:"+TA));
		doc.add(new Paragraph("CCA:"+CCA));
		doc.add(new Paragraph("Medical Allonce:"+M_a));
		doc.add(new Paragraph("                                "));
		doc.add(new Paragraph("PF:"+pf));
		doc.add(new Paragraph("GPF:"+gpf));
		doc.add(new Paragraph("LIC:"+lic));
		doc.add(new Paragraph("                                "));
		doc.add(new Paragraph("Final Salary:"+Gross_salary));
		
		//close the PDF file  
		doc.close();  
		//closes the writer  
		writer.close();  
		
		}   
		catch (DocumentException e)  
		{  
		e.printStackTrace();  
		}   
		catch (FileNotFoundException e)  
		{  
		e.printStackTrace();  
		} 

}
   void calaculate2(String name,String City,String bnum,String Roll,int fi,int quann,int a){
	   float gst=((18*100)/fi);
	   float fin=fi+gst;
	   Document doc = new Document();  
		try  
		{  
			String s1="D:\\"+name+"Sale"+".pdf";
		PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(s1));  
		System.out.println("PDF created.");  
		//opens the PDF  
		doc.open();  
		
		doc.add(new Paragraph("Name-"+name+"                                           "+"City-"+City+"                           "+"Mobile Number-"+bnum));
//		doc.add(new Paragraph(age));
//		doc.add(new Paragraph(Enum));  
		doc.add(new Paragraph("Purchesing item:"+Roll));  
		doc.add(new Paragraph("Quantity:"+quann));
		doc.add(new Paragraph("Per kg:"+a));
		doc.add(new Paragraph("--------------------------------------------------"));
		doc.add(new Paragraph("GST 18%:"+gst));
		doc.add(new Paragraph("Total Bill:"+fin));
		

		//close the PDF file  
		doc.close();  
		//closes the writer  
		writer.close();  
		
		}   
		catch (DocumentException e)  
		{  
		e.printStackTrace();  
		}   
		catch (FileNotFoundException e)  
		{  
		e.printStackTrace();  
		} 

	   
	   
	   
   }
}