package Bewakoof_Header_Next_Page;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.expectThrows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Winterwear_Page {

	WebDriver driver;

	@FindBy(xpath = "//button[@class='sortbyButton']")
	WebElement filer;

	@FindBy(xpath = "//a[text()='Price : High to Low']")
	WebElement filter_Values;

	/*
	 * @FindBy(xpath = "//div[@class='discountedPriceText clr-p-black   false  ']")
	 * List<WebElement> locating_all_the_prize_element;
	 */

	public Winterwear_Page(WebDriver IDriver) {
		this.driver = IDriver;
	}

	public void clicking_on_header() throws Exception {

		ArrayList<String> re = Funtions.Read_Header_Names_From_Sheet();

		ArrayList<Integer> store_numbers = new ArrayList<Integer>();

		ArrayList<String> verification = Funtions.Read_Header_Names_From_Sheet_Verification();
		ArrayList<String> filerURL_s = Funtions.FIlter_URL();

		for (int i = 0; i < re.size(); i++) {

			driver.navigate().refresh();
			
			String data = String.format("//a[text()='%s']", re.get(i));

			WebElement header_Data = driver.findElement(By.xpath(data));
			header_Data.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

			String verification_url = verification.get(i);

			String url = driver.getCurrentUrl();

			assert url.contains(verification_url)
					: "Verification Failed for " + re.get(i) + ": URL does not contain '" + verification_url + "'.";
			System.out.println("Verification Passed for " + re.get(i) + ": URL contains '" + verification_url + "'.");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			if (verification_url.contains("/winter-wear-collection?category=sweatshirt_hoodies_jacket_sweater&sizes=XS_S_M_L_XL_2XL_3XL&sort=new")) 
			{
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				Actions action = new Actions(driver);
				action.moveToElement(filer).build().perform();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				action.moveToElement(filter_Values).click().build().perform();

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

				driver.navigate().refresh();
				List<WebElement> locate = driver
						.findElements(By.xpath("//div[@class='discountedPriceText clr-p-black   false  ']"));

				for (WebElement ele1 : locate) {
					String text = ele1.getText();
					String getting_prize = text.replace("₹", "");
					int prize_number_in_int_format = Integer.parseInt(getting_prize);
					store_numbers.add(prize_number_in_int_format);
				}

				boolean checker = Funtions.HighToLow(store_numbers);

				
				if (checker) {
					System.out.println("Order: High to Low = " + checker);
				} else {
					throw new Exception("Order is not fine for High to Low");
				}

				if (driver.getCurrentUrl().contains(filerURL_s.get(i))) {
					Assert.assertTrue(true);
					System.out.println("Yes URL contains New Parameters as HIGH TO LOW");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.navigate().to("https://www.bewakoof.com/");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				} else {
					Assert.assertTrue(false);
					System.out.println("No URL contains NO New Parameters as HIGH TO LOW");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
					driver.navigate().to("https://www.bewakoof.com/");
				}
			} else {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				driver.navigate().to("https://www.bewakoof.com/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			}

		}
	}
}
