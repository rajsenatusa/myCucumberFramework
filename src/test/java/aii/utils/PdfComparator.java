package aii.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;


public class PdfComparator extends CommonMethods{
	
	public static WebDriver driver;
	
	
	public static String getPdfName(WebDriver driver) throws Exception 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd_yyy_HH_mm_ss");
		LocalDateTime currentDate = LocalDateTime.now();
			String strURL = driver.getCurrentUrl();
			String[] elements = strURL.split("::");
			String pdfForm = elements[3];
			String form2= replaceMethod(pdfForm, ".pdf", "");
			String final_form = form2+dtf.format(currentDate)+".pdf";
			return final_form;
		
	}
	
	public static String makePdf(WebDriver driver, String name) throws Exception 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd_yyy_HH_mm_ss");
		LocalDateTime currentDate = LocalDateTime.now();
			
			String form2= replaceMethod(name, ".pdf", "");
			String final_form = form2+dtf.format(currentDate)+".pdf";
			return final_form;
		
	}
	
	
	public static String getPolicyFileTabPdfName(WebDriver driver, String name) throws Exception 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd_yyy_HH_mm_ss");
		LocalDateTime currentDate = LocalDateTime.now();
			
			String final_form = name+dtf.format(currentDate)+".pdf";
			return final_form;
		
	}

	public static void verifyFormData(WebDriver driver, String actual, String expected) throws Exception 
	{
		
		if(actual.contains(expected.trim()))
		{
			System.out.println("PDF Text available for Actual:  "+actual+"Expected:  "+expected);
		}
		else
		{
			System.out.println("PDF Text not available for Actual:  "+actual+"Expected:  "+expected);
		}
		
	}
	
	
	public static void verifyPDFText(WebDriver driver, String actual, String expected) throws Exception 
	{
		
		if(actual.contains(expected))
		{
			System.out.println("PDF Text available :  "+expected);
		}
		else
		{
			System.out.println("PDF Text not available :  "+expected);
		}
		
	}
	
	public static boolean verifyPDFText_NotVisible(WebDriver driver, String actual, String expected) throws Exception {

		try {
			if(!(actual.contains(expected))) {  
				System.out.println("Not visible: " +  expected);
            	return true;
            	}
			else
			{
				System.out.println("Not visible: " +  expected);
				return false;
			}
            
         } catch(Exception e) {
         	e.printStackTrace();
         	return false;
         	}
	}
	
	public static String getPDFData(String FilePath) throws Exception {
		
		
		File file = new File(FilePath);
		PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
		
		parser.parse();

		COSDocument document = parser.getDocument();

		PDFTextStripper PDFStripper = new PDFTextStripper();
		PDDocument PDF = new PDDocument(document);
		
		String parsedText;
		parsedText = PDFStripper.getText(PDF);
		

		if (document != null) {
			document.close();
			}
		if (PDF != null) {
			PDF.close();
			}
		
		PrintWriter writer = new PrintWriter("Data/pdf.txt");
		writer.print(parsedText);
		writer.close();
		return parsedText;
	}

	
	
	public static void SavePdfForm(WebDriver driver, String path) throws Exception 
	{
		try {
			
			
			//Save the file in local
			StringSelection ss = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			
  //Imitate mouse events like ENTER, CTRL+C, CTRL+V
			Robot robot = new Robot();
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			
//			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);
			driver.close();
			driver.switchTo().window(mainWindow);
		}catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	public static void switchWindows(WebDriver driver) {
		
		try{
			String  originalHandles = driver.getWindowHandle();
			 
			for(String handle : driver.getWindowHandles())
			{
				if(!handle.equals(originalHandles))
				{
					driver.switchTo().window(handle);
					Thread.sleep(2000);
					driver.close();
				}
			}
			driver.switchTo().window(originalHandles);
			 
		} catch(Exception e){
		e.printStackTrace();
		}
	}


}
