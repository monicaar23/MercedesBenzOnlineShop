package contactMe;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public WebDriver driver;
	
	public WebDriver getBrowser(String browserType) {
		switch (browserType) {
		case "firefox":
		{
			System.out.println("Opening Firefox browser");
			WebDriver driver;
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	       return	driver;
		}
		case "chrome":
		{
			System.out.println("Opening Chrome browser");
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
	        driver.manage().window().setPosition(new Point(0,0));
			driver.manage().window().setSize(new Dimension(1024,768));
			
			return	driver;
		}
		case "IE":
		{
			System.out.println("Opening Internet Explorer browser");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
			driver.manage().window().setPosition(new Point(0,0));
			driver.manage().window().setSize(new Dimension(1024,768));
			
			return	driver;
		}
	}
		return driver = new ChromeDriver();
	}
}