package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
	
	private WebDriver driver;
	
	private String item = "//div[@class='cart_list']/div[3]/div/a/div[contains(text(),'ITEM_NAME')]";
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyItemAddedToCart(String itemName) {
		Assert.assertTrue(driver.findElements(By.xpath(item.replace("ITEM_NAME", itemName))).size() > 0);
	}
}
