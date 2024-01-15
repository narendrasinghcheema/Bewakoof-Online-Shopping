package Bewakoof_Home_Page;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Home_page_Mobile_Covers {

	WebDriver driver;

	@FindBy(xpath = "//span[text()='MOBILE COVERS']")
	WebElement mobile_Cover_header;

	public Home_page_Mobile_Covers(WebDriver IDriver) {
		this.driver = IDriver;
	}

	public void select_mobile_Cover_header() throws IOException {
		ArrayList<String> mobile_cover_data = Funtions.Read_Mobile_Cover_Header_Data();
		ArrayList<String> verification = Funtions.Mobile_cover_verification_Page();

		for (int i = 0; i < mobile_cover_data.size(); i++) {
			Actions action = new Actions(driver);

			action.moveToElement(mobile_Cover_header).build().perform();

			String xp = String.format("//a[text()='%s']", mobile_cover_data.get(i));
			WebElement mobile_cover_dropDown = driver.findElement(By.xpath(xp));
			action.moveToElement(mobile_cover_dropDown).click().build().perform();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

			String verification_details = verification.get(i);

			String verification_element = String
					.format("//h1[contains(@class, 'pageTitle') and contains(text() , \"%s\")]", verification_details);

			WebElement verification_code_for_page = driver.findElement(By.xpath(verification_element));

			try {
				if (verification_code_for_page.isDisplayed()) {
					System.out.println("Mobile cover Page is correct");
				} else {
					throw new AssertionError("Mobile cover Page is not correct");
				}
			} catch (AssertionError e) {

				e.printStackTrace();
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

			driver.navigate().to("https://www.bewakoof.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	}

}
