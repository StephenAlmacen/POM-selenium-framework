package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.Browser;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
	WebDriver driver;
	LoginPage lp;
	HomePage hp;

	@BeforeTest
	public void browserlaunch() {
		driver = Browser.StartBrowser("Chrome", "https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
	}

	// Login to Site
	@Test(priority = 1)
	public void Login() {
		try {
			lp.loginToSite("standard_user", "secret_sauce");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Verifing the Home Page.
	@Test(priority = 2)
	public void HomePageVerify() {
		try {
			hp.verifyHomepage();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
