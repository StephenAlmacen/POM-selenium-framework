package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	private By usernameTextField = By.xpath("//input[@id='user-name']");
	private By passwordTextField = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//input[@id='login-button']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginToSite(String Username, String Password) {
		this.enterUsername(Username);
		this.enterPasssword(Password);
		this.clickLogin();
	}

	public void enterUsername(String Username) {
		driver.findElement(usernameTextField).sendKeys(Username);
	}

	public void enterPasssword(String Password) {
		driver.findElement(passwordTextField).sendKeys(Password);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

}
