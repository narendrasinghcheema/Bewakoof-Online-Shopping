package Bewakoof_Home_Page;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Home_page_Woman {

	WebDriver driver;

	@FindBy(xpath = "//span[text()='WOMEN']")
	WebElement woman_Header;

	public Home_page_Woman(WebDriver IDriver) {
		this.driver = IDriver;
	}

	public void select_woman_header() throws IOException {

		ArrayList<String> woman = Funtions.Read_Woman_Header_Data();
		ArrayList<String> Woman_Verificatio_Page = Funtions.Woman_Verification_Pages();

		for (int i = 0; i < woman.size(); i++) {
			Actions action = new Actions(driver);
			action.moveToElement(woman_Header).build().perform();
			String xp = String.format("(//span[text()='%s'])[1]", woman.get(i));
			WebElement woman_dropdown = driver.findElement(By.xpath(xp));
			action.moveToElement(woman_dropdown).click().build().perform();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

			String details = Woman_Verificatio_Page.get(i);

			String Verification_Massage = String
					.format("//h1[contains(@class, 'searchResults') and contains(text(), \"%s\")]", details);

			WebElement verification_element = driver.findElement(By.xpath(Verification_Massage));

			try {
				if (verification_element.isDisplayed()) {
					System.out.println("Page is now correct.");
				} else {
					throw new AssertionError("Woman Page is not correct");
				}
			} catch (Exception e) {
				System.out.println("Caught an exception: " + e.getMessage());

			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

			driver.navigate().to("https://www.bewakoof.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
	}
}
