package Bewakoof_Header_Next_Page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Funtions {

	public static ArrayList<String> Read_Header_Names_From_Sheet() throws IOException {

		ArrayList<String> ar = new ArrayList<String>();

		FileInputStream file = new FileInputStream(
				"C:\\Users\\hp\\Downloads\\Bewakoof_Automation Data (Pages_Header_Details_Data).xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheetAt(0);

		int number = sheet.getLastRowNum();
		for (int i = 1; i <= number; i++) {

			String va = sheet.getRow(i).getCell(0).getStringCellValue();
			ar.add(va);
		}
		return ar;
	}

	public static ArrayList<String> Read_Header_Names_From_Sheet_Verification() throws IOException {
		ArrayList<String> ar1 = new ArrayList<String>();

		FileInputStream file = new FileInputStream(
				"C:\\Users\\hp\\Downloads\\Bewakoof_Automation Data (Pages_Header_Details_Data).xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheetAt(1);

		int number = sheet.getLastRowNum();
		for (int i = 1; i <= number; i++) {

			String va = sheet.getRow(i).getCell(0).getStringCellValue();
			ar1.add(va);
		}
		return ar1;
	}
}
