package contactMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectModel {

	public SelectModel(WebDriver driver) throws InterruptedException {
		Thread.sleep(100);
		WebElement model = driver.findElement(By.xpath("//span[contains(@class,'dcp-filter-icon__label')]  [contains(text(),'GLS')]"));
		model.click();
		System.out.println("Model Selected");
	}

}
