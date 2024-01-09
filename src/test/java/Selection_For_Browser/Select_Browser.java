package Selection_For_Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Select_Browser {

	static WebDriver driver;
	public static WebDriver select(String browser_name, String url)
	{
		if(browser_name.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}else if(browser_name.equalsIgnoreCase("chrome"))
		{
			System.getProperty("webdriver.chrome.driver", "G:/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
		
		
		
	}
}
