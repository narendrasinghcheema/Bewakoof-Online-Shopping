package Bewakoof_Header_Next_Page;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args) throws IOException
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bewakoof.com/winter-wear-collection?category=sweatshirt_hoodies_jacket_sweater&sizes=XS_S_M_L_XL_2XL_3XL&sort=high");
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='discountedPriceText clr-p-black   false  ']"));
	
		
		for(WebElement ele1 : ele)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String save = ele1.getText();
			
			String a = save.replace("₹", "");
			System.out.println("removing rupee - "+a);
		}
		
	}
}
