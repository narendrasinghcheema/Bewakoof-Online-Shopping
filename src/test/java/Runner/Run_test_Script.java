package Runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Bewakoof_Home_Page.Home_Page;
import Selection_For_Browser.Select_Browser;

public class Run_test_Script {

	WebDriver driver;
	Home_Page obj1;
	
	@BeforeTest
	public void Start_browser()
	{
		driver = Select_Browser.select("firefox", "https://www.bewakoof.com");
	}
	
	@Test
	public void Home_Screen() throws IOException
	{
		obj1 = PageFactory.initElements(driver, Home_Page.class);
		obj1.select_Men_header();
	}
}
