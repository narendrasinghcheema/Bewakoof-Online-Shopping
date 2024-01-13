package Runner;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Bewakoof_Home_Page.Home_Page;
import Bewakoof_Home_Page.Home_page_Mobile_Covers;
import Bewakoof_Home_Page.Home_page_Woman;
import Selection_For_Browser.Select_Browser;

public class Run_test_Script {

	WebDriver driver;
	Home_Page obj1;
	Home_page_Woman obj2;
	Home_page_Mobile_Covers obj3;

	@BeforeTest
	public void Start_browser() {
		driver = Select_Browser.select("firefox", "https://www.bewakoof.com");
	}

	@Test
	public void Home_Screen() throws IOException {
		obj1 = PageFactory.initElements(driver, Home_Page.class);

		obj1.select_Men_header();

	}

	@Test(dependsOnMethods = "Home_Screen")
	public void Home_Screen_woman() throws IOException {
		obj2 = PageFactory.initElements(driver, Home_page_Woman.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		obj2.select_woman_header();
	}

	@Test(dependsOnMethods = "Home_Screen_woman")
	public void Home_Screen_Mobile_cover() throws IOException {
		obj3 = PageFactory.initElements(driver, Home_page_Mobile_Covers.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		obj3.select_mobile_Cover_header();
	}
}
