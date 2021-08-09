package contactMe;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactMePageValidation {
	
	
	public boolean proceedButton(String scenario, WebDriver driver, String firstName, String lastName, String email, String phoneNumber) throws InterruptedException, IOException {
		System.out.println(scenario);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='app']/div/main/div/div/div[7]/div/div/div/div[2]/div/div/div/div/form/div/div/wb-input-control/wb-input/input")).sendKeys(firstName);
		driver.findElement(By.xpath("//div[@id='app']/div/main/div/div/div[7]/div/div/div/div[2]/div/div/div/div/form/div/div[2]/wb-input-control/wb-input/input")).sendKeys(lastName);
		driver.findElement(By.xpath("//div[@id='app']/div/main/div/div/div[7]/div/div/div/div[2]/div/div/div/div/form/div/div[3]/wb-input-control/wb-input/input")).sendKeys(email);
		driver.findElement(By.xpath("//div[@id='app']/div/main/div/div/div[7]/div/div/div/div[2]/div/div/div/div/form/div/div[4]/wb-input-control/wb-input/input")).sendKeys(phoneNumber);
		
		Thread.sleep(4000);
		WebElement privacyPol = driver.findElement(By.xpath("//input[@data-test-id='rfq-contact__consent-data-privacy']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(privacyPol).click().perform();
		
		Thread.sleep(3000);
		WebElement markCons = driver.findElement(By.xpath("//input[@data-test-id='rfq-contact__consent-marketing']"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(markCons).click().perform();
		
		WebElement proceedButton = driver.findElement(By.xpath("//button[@data-test-id='dcp-rfq-contact-button-container__button-next']"));
		Actions action = new Actions(driver);
		action.moveToElement(proceedButton).perform();
		//Thread.sleep(3000);
		String printFolder = System.getProperty("user.dir")+"\\TestScreenshots";
		File dir = new File(printFolder);
		 if (!dir.exists())
				dir.mkdir();
		 String printFile = System.getProperty("user.dir")+"\\TestScreenshots\\"+scenario+".jpg";
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(printFile);
		if (DestFile.exists())
			DestFile.delete();
		FileUtils.copyFile(SrcFile, DestFile); 
		System.out.println("Screenshot saved at: "+printFile);
		return proceedButton.isEnabled();
	}
	
}
