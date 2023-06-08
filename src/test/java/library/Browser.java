package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	private static WebDriver driver;
	private static ChromeOptions chromeOptions = new ChromeOptions();
	
	public static WebDriver StartBrowser(String browsername, String url) {
			
		// If the browser is Firefox
		if (browsername.equalsIgnoreCase("Firefox")) {
			// Set the path for geckodriver.exe
			System.setProperty("webdriver.firefox.marionette", " E://Selenium//Selenium_Jars//geckodriver.exe ");
			driver = new FirefoxDriver();
		}

		// If the browser is Chrome
		else if (browsername.equalsIgnoreCase("Chrome")) {
			// Set the path for chromedriver.exe
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sdalmacen\\Documents\\Selenium\\driver\\chromedriver.exe");
			chromeOptions.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(chromeOptions);
		}
		
		// If the browser is IE
		else if (browsername.equalsIgnoreCase("IE")) {
			// Set the path for IEdriver.exe
			System.setProperty("webdriver.ie.driver", "E://Selenium//Selenium_Jars//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
