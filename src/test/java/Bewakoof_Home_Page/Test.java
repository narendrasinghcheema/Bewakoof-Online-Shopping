package Bewakoof_Home_Page;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static void main(String[] args) throws IOException
{
	FileInputStream file = new FileInputStream("C:\\Users\\hp\\Downloads\\Bewakoof_Automation Data (Home_Page_Mobile_Cover).xlsx");
	XSSFWorkbook workBook = new XSSFWorkbook(file);
	XSSFSheet sheet = workBook.getSheetAt(1);
	
	int number = sheet.getLastRowNum();
	for(int i=1;i<=number;i++)
	{
		String a = sheet.getRow(i).getCell(0).getStringCellValue();
		System.out.println("a = "+a);
	}
	
	
}
}
