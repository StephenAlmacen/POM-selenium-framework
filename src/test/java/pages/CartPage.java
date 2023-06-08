package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private String item = "//div[@class='cart_list']/div[3]/div/a/div[contains(text(),'ITEM_NAME')]";
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void verifyItemAddedToCart(String itemName) {
		Assert.assertTrue(driver.findElements(By.xpath(item.replace("ITEM_NAME", itemName))).size() > 0);
	}
}
