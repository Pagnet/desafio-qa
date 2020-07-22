package blu.desafio.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver;
	
	
	public static WebDriver getDriver(){
		if(driver == null) {    
			System.setProperty("webdriver.chrome.driver", "src\\libs\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static void killDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
