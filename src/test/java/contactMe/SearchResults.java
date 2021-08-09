package contactMe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults {

	public WebDriver carSearchResults(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait2 = new WebDriverWait(driver,10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("dcp-result-pagination__label")));
		Thread.sleep(3000);
		List<WebElement> carModels = driver.findElements(By.xpath("//h3[@data-test-id='dcp-cars-product-tile__model']"));
		//Select the first model
		carModels.get(0).click();
		System.out.println("Car selected");
		
		String url2 = driver.getCurrentUrl();
		driver.get(url2);
		
		System.out.println("Car details page URL:" +url2);
		
		return driver;
	}

}
