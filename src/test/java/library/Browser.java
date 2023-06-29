package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Browser {
	private static WebDriver driver;
	private static ChromeOptions chromeOptions = new ChromeOptions();
	private static ConfigFile configFile = new ConfigFile();

	public static WebDriver StartBrowser(String browsername, String url) {
		// If the browser is Firefox		
		if (browsername.equalsIgnoreCase("Firefox")) {
			// Set the path for geckodriver.exe
			System.setProperty(configFile.getDriverType(), configFile.getDriverPath());
			driver = new FirefoxDriver();
		}

		// If the browser is Chrome
		else if (browsername.equalsIgnoreCase("Chrome")) {
			// Set the path for chromedriver.exe
			WebDriverManager.chromedriver().setup();
			 ChromeOptions options = new ChromeOptions();
		     options.addArguments("--headless", "--window-size=1440,768", "--disable-gpu");
		     driver = new ChromeDriver(options);
		     driver.manage().deleteAllCookies();
		     driver.manage().window().maximize();
		}

		// If the browser is IE
		else if (browsername.equalsIgnoreCase("IE")) {
			// Set the path for IEdriver.exe
			System.setProperty(configFile.getDriverType(), configFile.getDriverPath());
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
