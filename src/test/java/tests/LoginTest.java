package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	LoginPage lp;
	HomePage hp;

	@BeforeTest
	public void browserlaunch() throws Exception {
		BasicConfigurator.configure();
		dr = new DataRepository(configFile.getDataRepositoryPath(), "LoginTestDataSheet");
		driver = Browser.StartBrowser(configFile.getBrowserType(), configFile.getURL());
		driver.manage().timeouts().implicitlyWait(configFile.getWaitDuration(), TimeUnit.SECONDS);
		lp = new LoginPage(driver, logger);
		hp = new HomePage(driver, logger);
		logger.info("---Starting LoginTest---");
	}

	// Login to Site
	@Test(priority = 1)
	public void Login() {
		lp.loginToSite(dr.getStringCellValue("Username"), dr.getStringCellValue("Password"));
		hp.verifyHomepage();

	}

	@AfterTest
	public void closeBrowser() {
		logger.info("---Ending LoginTest---");
		driver.quit();
	}
}
