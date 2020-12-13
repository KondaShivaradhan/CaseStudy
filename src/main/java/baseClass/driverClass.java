package baseClass;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import pageClass.loginPage;

public class driverClass {

	public static WebDriver driver;
	public static Properties prop;

	public void invokeBrowser(String browserName) {
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		if (prop == null) {
			prop = new Properties();
			FileInputStream file = null;
			try {
				file = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\main\\java\\objectRepository\\data.properties");
				prop.load(file);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void openURL2(String xpathKey) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty(xpathKey));
	}

	public void openURL(String xpathKey) {
		driver.get(prop.getProperty(xpathKey));
	}

	public void openURL3(String xpathKey) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		driver.get(prop.getProperty(xpathKey));
	}

	public String actualTitle, expectedTitle;

	public loginPage verifyLoginPage() {
		actualTitle = driver.getTitle();
		expectedTitle = prop.getProperty("expected");
		if (actualTitle.matches(expectedTitle))
			System.out.println("Landed on home page successfully");
		else
			System.out.println("Not landed on home page successfully");
		return new loginPage();
	}
}
