package Bewakoof_Header_Next_Page;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Winterwear_Page {

	WebDriver driver;

	public Winterwear_Page(WebDriver IDriver) {
		this.driver = IDriver;
	}

	public void clicking_on_header() throws IOException 
	{
		ArrayList<String> re = Funtions.Read_Header_Names_From_Sheet();
		
		ArrayList<String> verification = Funtions.Read_Header_Names_From_Sheet_Verification();

		for (int i = 0; i < re.size(); i++)
		{
			
			String data = String.format("//a[text()='%s']", re.get(i));
			
			WebElement header_Data = driver.findElement(By.xpath(data));
			header_Data.click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			
			String verification_url = verification.get(i);
			
			String url = driver.getCurrentUrl();
			
			assert url.contains(verification_url) :  "Verification Failed for " + re.get(i) + ": URL does not contain '" + verification_url + "'.";
			 System.out.println("Verification Passed for " + re.get(i) + ": URL contains '" + verification_url + "'.");
			 
			 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 driver.navigate().to("https://www.bewakoof.com/");
		}
	}
}
