package tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.Browser;
import library.ConfigFile;
import library.DataRepository;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest {
	WebDriver driver;
	CartPage cp;
	XSSFSheet sheet;
	DataRepository dr;
	ConfigFile configFile;
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	LoginPage lp;
	HomePage hp;

	@BeforeTest
	public void browserlaunch() throws Exception {
		BasicConfigurator.configure();
		configFile = new ConfigFile();
		dr = new DataRepository(configFile.getDataRepositoryPath(), "LoginTestDataSheet");
		driver = Browser.StartBrowser(configFile.getBrowserType(), configFile.getURL());
		driver.manage().timeouts().implicitlyWait(configFile.getWaitDuration(), TimeUnit.SECONDS);
		lp = new LoginPage(driver, logger);
		hp = new HomePage(driver, logger);
		cp = new CartPage(driver, logger);
		logger.info("---Starting HomeTest---");
	}

	// Login to Site
	@Test(priority = 1)
	public void VerifyAddItemtoCart() throws Exception {
		lp.loginToSite(dr.getStringCellValue("Username"), dr.getStringCellValue("Password"));
		hp.verifyHomepage();
		dr = new DataRepository(configFile.getDataRepositoryPath(), "HomepageTestDataSheet");
		hp.addItemToCart(dr.getStringCellValue("ItemName"));
		hp.clickShoppingCart();
		cp.verifyItemAddedToCart(dr.getStringCellValue("ItemName"));
	}

	@AfterTest
	public void closeBrowser() {
		logger.info("---Ending HomeTest---");
		driver.quit();
	}
}
