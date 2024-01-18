package Bewakoof_Header_Next_Page;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static void main(String[] args) throws IOException
	{
		FileInputStream file = new FileInputStream(
				"C:\\Users\\hp\\Downloads\\Bewakoof_Automation Data (Pages_Header_Details_Data).xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheetAt(1);
		
		String s = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println("S = "+s);
	
	}
}
