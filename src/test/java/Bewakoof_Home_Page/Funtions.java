package Bewakoof_Home_Page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Funtions {

	public static ArrayList<String> readMen_Headerfrom_Sheet() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\hp\\Downloads\\Bewakoof_Automation Data (Home_Page).xlsx");
		ArrayList<String> co1 = new ArrayList<String>();

		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheetAt(0);

		// String ans = sheet.getRow(1).getCell(0).getStringCellValue();
		int number = sheet.getLastRowNum();
		for (int i = 1; i <= number; i++) {

			String values1 = sheet.getRow(i).getCell(0).getStringCellValue();

			co1.add(values1);

		}

		return co1;

	}

	public static ArrayList<String> verification_Page() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\hp\\Downloads\\Bewakoof_Automation Data (Home_Page).xlsx");
		ArrayList<String> co2 = new ArrayList<String>();
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheetAt(1);

		int number = sheet.getLastRowNum();

		for (int i = 1; i <= number; i++) {

			String values2 = sheet.getRow(i).getCell(0).getStringCellValue();

			co2.add(values2);

		}

		return co2;
	}

}
