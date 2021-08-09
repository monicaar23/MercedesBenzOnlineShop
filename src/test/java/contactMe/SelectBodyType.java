package contactMe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectBodyType {

	public SelectBodyType(WebDriver driver) throws InterruptedException {
		//Select Body types
		Thread.sleep(2000); 
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'dcp-vehicle-category-filter-row__label')]  [contains(text(),'SUV')]")));
		WebElement bodyTypeName = driver.findElement(By.xpath("//span[contains(@class,'dcp-vehicle-category-filter-row__label')]  [contains(text(),'SUV')]"));
		//bodyTypeName.click();
		WebElement parent = bodyTypeName.findElement(By.xpath(".."));
		WebElement button1 = parent.findElement(By.xpath("//button[@data-test-id='bodyType-vehicle-category-filter-row-selector-1']"));
		button1.click();
		System.out.println("Body type Selected");
	}

}
