package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.Browser;
import library.ConfigFile;
import library.DataRepository;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
	WebDriver driver;
	XSSFSheet sheet;
	DataRepository dr;
	ConfigFile configFile = new ConfigFile();

	LoginPage lp;
	HomePage hp;

	@BeforeTest
	public void browserlaunch() throws Exception {
		dr = new DataRepository(configFile.getDataRepositoryPath(), "LoginTestDataSheet");
		driver = Browser.StartBrowser(configFile.getBrowserType(), configFile.getURL());
		driver.manage().timeouts().implicitlyWait(configFile.getWaitDuration(), TimeUnit.SECONDS);
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
	}

	// Login to Site
	@Test(priority = 1)
	public void Login() {
		lp.loginToSite(dr.getStringCellValue("Username"), dr.getStringCellValue("Password"));

	}

	// Verifing the Home Page.
	@Test(priority = 2)
	public void VerifyHomePage() {
		hp.verifyHomepage();
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
