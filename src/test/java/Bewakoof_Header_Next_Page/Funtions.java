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

	public static ArrayList<String> FIlter_URL() throws IOException {
		ArrayList<String> ar1 = new ArrayList<String>();

		FileInputStream file = new FileInputStream(
				"C:\\Users\\hp\\Downloads\\Bewakoof_Automation Data (Filter_Bases_URL).xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);

		int number = sheet.getLastRowNum();

		for (int i = 1; i <= number; i++) {
			String values = sheet.getRow(i).getCell(0).getStringCellValue();
			ar1.add(values);
		}
		return ar1;
	}
	
	

    public static boolean LowToHigh(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) < numbers.get(i + 1)) {
                return true; // Not in descending order
            }
        }
        return true; // All elements are in descending order
    }

	public static boolean HighToLow(ArrayList<Integer> numbers) {
		for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) >= numbers.get(i + 1)) {
                return true; // Not in ascending order
            }
        }
        return false;
		
	}
}
