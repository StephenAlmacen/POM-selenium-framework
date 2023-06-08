package pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import library.ConfigFile;

public class CartPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private ConfigFile configFile = new ConfigFile();
	private Logger logger = LogManager.getLogger(HomePage.class);

	private String item = "//div[@class='cart_list']/div[3]/div/a/div[contains(text(),'ITEM_NAME')]";

	public CartPage(WebDriver driver, Logger logger) {
		this.driver = driver;
		this.logger = logger;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(configFile.getWaitDuration()));
	}

	public void verifyItemAddedToCart(String itemName) {
		logger.info("Verifying homepage...");
		try {
			wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(item.replace("ITEM_NAME", itemName)), 1));
		} catch (Exception e) {
			logger.error(e);
		}
		Assert.assertTrue(driver.findElements(By.xpath(item.replace("ITEM_NAME", itemName))).size() > 0);
		logger.info("Sucessfully added "+ itemName + " to cart");
	}
}
