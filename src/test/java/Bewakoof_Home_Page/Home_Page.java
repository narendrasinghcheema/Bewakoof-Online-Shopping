package Bewakoof_Home_Page;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Home_Page {

	WebDriver driver;

	@FindBy(xpath = "//span[text()='MEN']")
	WebElement Header_Men;

	public Home_Page(WebDriver IDriver) {
		this.driver = IDriver;
	}

	public void select_Men_header() throws IOException {
		
		ArrayList<String> details = Funtions.readMen_Headerfrom_Sheet();

		ArrayList<String> verification = Funtions.verification_Page();

		for (int i = 0; i < details.size(); i++) {
			Actions action = new Actions(driver);
			action.moveToElement(Header_Men).build().perform();
			String x_path = String.format("(//span[text()='%s'])[1]", details.get(i));

			
			
			WebElement click_perform = driver.findElement(By.xpath(x_path));
			action.moveToElement(click_perform).click().build().perform();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

			
			String s = verification.get(i);
			System.out.println("Xpath = " + s);
		

			String verification_massage = String
					.format("//h1[contains(@class, 'searchResults') and contains(text(), \"%s\")]", s);
			
			System.out.println("verification_massage = " + verification_massage);
			WebElement verificationElement = driver.findElement(By.xpath(verification_massage));

			if (verificationElement.isDisplayed()) {
				System.out.println("Page is now correct.");
			} else {
				System.out.println("Page is not correct");
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

			driver.navigate().to("https://www.bewakoof.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		}

	}
}
