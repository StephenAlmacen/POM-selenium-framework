package pages;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	private Logger logger = LogManager.getLogger(LoginPage.class);

	private By usernameTextField = By.xpath("//input[@id='user-name']");
	private By passwordTextField = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//input[@id='login-button']");

	public LoginPage(WebDriver driver, Logger logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public void loginToSite(String Username, String Password) {
		logger.info("Logging in as " + Username);
		try {
			this.enterUsername(Username);
			this.enterPasssword(Password);
			this.clickLogin();
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void enterUsername(String Username) {
		logger.info("Entering username: " + Username);
		try {
			driver.findElement(usernameTextField).sendKeys(Username);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void enterPasssword(String Password) {
		logger.info("Entering password: " + Password);
		try {
			driver.findElement(passwordTextField).sendKeys(Password);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void clickLogin() {
		logger.info("Logging in...");
		try {
			driver.findElement(loginButton).click();
		} catch (Exception e) {
			logger.error(e);
		}

	}

}
