package base.testbase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.reportbase.ExtentManager;

public class Hooks extends TestBase {

	private static ExtentReports extent;
	public static String startExecutionSuite;
	public static String suiteName;
	public static String className;
	public static String methodName;
	public static String iterationName;
	
	@Parameters({ "productName", "systemUrl", "browser", "dimensionWidth", "dimensionHeight", "environmentExecution", "remoteURL", "driverPath", "browserVersion", "enableVNC", "reportStrategy", "printAllSteps" })
	@BeforeSuite
	public synchronized void beforeSuite(
			ITestContext context,
			String productName,
			String systemUrl,
			String browser,
			String dimensionWidth,
			String dimensionHeight,
			String environmentExecution,
			String remoteURL,
			String driverPath,
			String browserVersion,
			String enableVNC,
			String reportStrategy,
			String printAllSteps
			) {
		
		startExecutionSuite = Util.getCurrentTimeStamp("dd-MM-yyyy_HH-mm-ss-SSS");
		suiteName = context.getSuite().getXmlSuite().getName();

		reportPath = TEST_OUTPUT_PATH + FS + 
				"Reports" + "_" + productName + FS + 
				suiteName + "_" + startExecutionSuite;
		createDir(reportPath);

		extent = ExtentManager.createInstance(productName, reportStrategy, reportPath + FS + productName + "_ExtentReport.html");

		
		System.out.println("[INFO] Starting suite \"" + suiteName + "\"");
	}

	@BeforeClass
	public synchronized void beforeClass(ITestContext context) {
		className = context.getCurrentXmlTest().getName();
		
		System.out.println("[INFO] Starting test class \"" + className + "\"");
		ExtentTest parent = extent.createTest(className);
		parentTest.set(parent);
	}
	
	@SuppressWarnings("static-access")
	@Parameters({ "productName", "systemUrl", "browser", "dimensionWidth", "dimensionHeight", "environmentExecution", "remoteURL", "driverPath", "browserVersion", "enableVNC", "reportStrategy", "printAllSteps"  })
	@BeforeMethod
	public synchronized void beforeMethod(
			Method method, 
			String productName,
			String systemUrl,
			String browser,
			String dimensionWidth,
			String dimensionHeight,
			String environmentExecution,
			String remoteURL,
			String driverPath,
			String browserVersion,
			String enableVNC,
			String reportStrategy,
			String printAllSteps
			) {
		
		methodName = method.getName();
		
		ExtentTest childTest = parentTest.get().createNode(methodName);
		test.set(childTest);
		
		screenshotAbsolutePath = "Reports" + "_" + productName + FS + 
				suiteName + "_" + startExecutionSuite + FS + 
				className + FS +
				methodName;
		
		
		screenshotPathLocal = TEST_OUTPUT_PATH + FS + 
				screenshotAbsolutePath;

		screenshotPath = "." + FS + 
				className + FS +
				methodName;
		
		if (printAllSteps.toLowerCase().equals("true")) 
			super.printAllSteps = true;
		

    	softAssert = new SoftAssert();
    	
		System.out.println("[INFO] Starting test method \"" + methodName + "\"");
		chooseDriverInstance(
				systemUrl, 
				browser,
				dimensionWidth,
				dimensionHeight,
				environmentExecution,
				remoteURL,
				driverPath,
				browserVersion,
				enableVNC
				);
	}

	@AfterMethod
	public synchronized void closeBrowser(ITestResult result) throws IOException, InterruptedException {
		
		
		if (result.getStatus() == ITestResult.FAILURE) {
			test.get().fail(result.getThrowable());
			TestBase.setStep("Inconsitencia encontrada.", result.getThrowable(), Status.FAIL);
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			test.get().skip(result.getThrowable());
			TestBase.setStep("Inconsitencia encontrada.", result.getThrowable(), Status.FAIL);
		}
		else {
			test.get().pass("Test passed");
			System.out.println("[PASSED] Test passed");
		}
			
		System.out.println("[INFO] Ending test method \"" + methodName + "\""); 
		TestBase.getDriver().close();
		TestBase.getDriver().quit();
		
		softAssert = null;
		
	}

	@AfterClass
	public synchronized void afterClass() {
		System.out.println("[INFO] Ending test class \"" + className + "\"");
		try {
			extent.flush();
		} catch (Exception e) {
			System.out.println("Flush error: " + e);
		}
	}

	@AfterSuite
	public synchronized void afterSuite() {
		System.out.println("[INFO] Ending suite \"" + suiteName + "\"");
	}

	private void chooseDriverInstance(
			String systemUrl, 
			String browser, 
			String dimensionWidth,
			String dimensionHeight,
			String environmentExecution,
			String remoteURL,
			String driverPath,
			String browserVersion,
			String enableVNC
			) {
		DesiredCapabilities capabilities;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("download.prompt_for_download", "true");
		
		if (dimensionWidth.equals("") && dimensionHeight.equals("")) 
			options.addArguments("window-size=1280,1024");
		else if (dimensionWidth.equals("")) 
			options.addArguments("window-size=1280" + dimensionHeight);
		else if (dimensionHeight.equals("")) 
			options.addArguments("window-size=" + dimensionWidth + ",1024");
		else 
			options.addArguments("window-size=" + dimensionWidth + "," + dimensionHeight);

		try {
			if (browser.toLowerCase().equals("chrome")) {
				
				if (environmentExecution.toLowerCase().equals("remote")) {
					
					capabilities = new DesiredCapabilities();
					capabilities.setBrowserName("chrome");
					capabilities.setVersion(browserVersion);
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					capabilities.setCapability("enableVideo", false);
					
					if (enableVNC.toLowerCase().equals("true"))
						capabilities.setCapability("enableVNC", true);
					else
						capabilities.setCapability("enableVNC", false);
					
					try {
						TestBase.setDriver(new RemoteWebDriver(URI.create(remoteURL).toURL(), capabilities));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}
				else if (environmentExecution.toLowerCase().equals("local")) {
			        
					if (driverPath.equals("")) 
				        TestBase.setDriver(new ChromeDriver(options));
					else {
						System.setProperty("webdriver.chrome.driver", driverPath);
						TestBase.setDriver(new ChromeDriver(options));
					}
				}
			}
			TestBase.getDriver().get(systemUrl);
		} catch (Exception e) {
			System.out.println("Instanced driver error : " + e);
		}
	}

}