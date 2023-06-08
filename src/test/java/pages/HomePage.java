package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;
	private By productHeader = By.xpath("//span[contains(text(),'Products')]");
	private By shoppingCartButton = By.xpath("//a[@class='shopping_cart_link']");
	private String item = "//div[@class='inventory_list']/div/div[2]/div/a/div[contains(text(),'ITEM_NAME')]/parent::a/parent::div/following-sibling::div/button";
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void verifyHomepage() {
		wait.until(ExpectedConditions.numberOfElementsToBe(productHeader, 1));
		Assert.assertTrue(driver.findElements(productHeader).size() > 0);
	}
	
	public void addItemToCart(String itemName) {
		driver.findElement(By.xpath(item.replace("ITEM_NAME", itemName))).click();
	}
	
	public void clickShoppingCart() {
		driver.findElement(shoppingCartButton).click();
	}
}
