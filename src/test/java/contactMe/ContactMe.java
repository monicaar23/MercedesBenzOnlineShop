package contactMe;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ContactMe {
	
	public String baseUrl = "https://shop.mercedes-benz.com/en-th/shop/vehicle/srp";  
	public WebDriver driver,driver1 ; 
	static ExtentTest test;
	static ExtentReports report;
	 	
	@BeforeSuite
	public void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportBenzContactMe.html");
	}
	
	@Parameters({"scenario","firstName","lastName","email","phoneNo"})
	@Test 
	
	public void test1(String scenario, String firstName, String lastName, String email, String phoneNo) throws InterruptedException, IOException {      
		System.out.println("Test running");
		//Select BodyType
		Thread.sleep(1000);
		SelectBodyType	s = new SelectBodyType(driver);
		//Choose a car and click on it
		Thread.sleep(3000);
		SearchResults r = new SearchResults();
		driver1 = r.carSearchResults(driver);
		//Click on Contact Me
		Thread.sleep(6000);
		WebElement contactMe = driver1.findElement(By.xpath("//button[@data-test-id='dcp-cars-buy-box__contact-seller']"));
		contactMe.click();
		System.out.println("Contact Me clicked"); 
		//Input contact details
		ContactMePageValidation c = new ContactMePageValidation();
		Boolean proceedEnabled = c.proceedButton(scenario, driver1, firstName, lastName, email, phoneNo);
		System.out.println("Contact details provided and the button status is:"+proceedEnabled);
		test = report.startTest(scenario);
		if(proceedEnabled)
			test.log(LogStatus.PASS, "Proceed button enabled");
		else
			test.log(LogStatus.FAIL, "Proceed button disabled");
	}   
	
	
	@BeforeTest  
	@Parameters({"scenario","browser"})
	public void beforeTest(String scenario, String browser) throws InterruptedException {    
		System.out.println("Before test running");  
		System.out.println("Browser requested is: "+browser);
		Browser b = new Browser();
		driver = b.getBrowser(browser);
		
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(1024,768));
		
		driver.get(baseUrl); 
		System.out.println("URL: " +baseUrl);
				
		//Thread.sleep(1000);
		WebDriverWait wait3 = new WebDriverWait(driver,90);
		try {
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Agree to all']")));
		
		driver.findElement(By.xpath("//*[text()='Agree to all']")).click();
		} catch (Exception e) {
			System.out.println("Error in Agree");
			test.log(LogStatus.FAIL, "Error in Acceping Cookies");
			e.printStackTrace();
		}
		driver.get(baseUrl); 	
		System.out.println("Cookied agree");
		Thread.sleep(1000);
		
		
		
	}     
	@AfterTest  
	public void afterTest() throws IOException, InterruptedException {  
		
		//driver.quit();
		System.out.println("Test Completed and browser left open for verification");
	}    
	@AfterSuite
	public void endTest()
	{
		report.endTest(test);
		System.out.println("End of test. Report updated");
		report.flush();
	}
}
