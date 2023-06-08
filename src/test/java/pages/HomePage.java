package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	private By productHeader = By.xpath("//span[contains(text(),'Products')]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void verifyHomepage() {
		wait.until(ExpectedConditions.numberOfElementsToBe(productHeader, 1));
		Assert.assertTrue(driver.findElements(productHeader).size() > 0);
	}
}
