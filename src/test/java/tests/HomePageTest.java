package tests;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.Browser;
import library.DataRepository;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest {
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	CartPage cp;
	XSSFSheet sheet;
	DataRepository dr;

	@BeforeTest
	public void browserlaunch() throws Exception {
		dr = new DataRepository(
				"C:\\Users\\sdalmacen\\selenium\\git\\repository\\POM-selenium-framework\\src\\test\\resources\\dataRepository\\PomSeleniumFramework.xlsx",
				"LoginTestDataSheet");
		driver = Browser.StartBrowser("Chrome", "https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		cp = new CartPage(driver);
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

	// Verifing the Home Page.
	@Test(priority = 3)
	public void VerifyAddItemtoCart() throws Exception {
		dr = new DataRepository(
				"C:\\Users\\sdalmacen\\selenium\\git\\repository\\POM-selenium-framework\\src\\test\\resources\\dataRepository\\PomSeleniumFramework.xlsx",
				"HomepageTestDataSheet");
		hp.addItemToCart(dr.getStringCellValue("ItemName"));
		hp.clickShoppingCart();
		cp.verifyItemAddedToCart(dr.getStringCellValue("ItemName"));
	}
	
	@AfterTest
	public void closeBrowser() {
//		driver.quit();
	}
}
