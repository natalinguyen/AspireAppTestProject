package commons;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import reportConfigs.VerificationFailures;

public class BaseTest {

	private WebDriver driver;
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver getDriver() {
		return driver;
	}

	public enum BROWSER {
		FIREFOX, CHROME, IE, SAFARI, H_CHROME, H_FIREFOX

	}

	public WebDriver getDriverBrowser(String browserName, String urlPage) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());

		if (browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().browserVersion("95").setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("-private");
			driver = new FirefoxDriver(firefoxOptions);

		} else if (browser == BROWSER.CHROME) {
			WebDriverManager.chromedriver().browserVersion("70").setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			driver = new ChromeDriver(chromeOptions);

		} else if (browser == BROWSER.SAFARI) {

			driver = new SafariDriver();

		} else if (browser == BROWSER.H_CHROME) {
			WebDriverManager.chromedriver().browserVersion("70").setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("headless");
			chromeOptions.addArguments("window-size=1920X1080");
			driver = new ChromeDriver(chromeOptions);
		} else if (browser == BROWSER.H_FIREFOX) {
			WebDriverManager.firefoxdriver().browserVersion("95").setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(true);
			firefoxOptions.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(firefoxOptions);
		} else {

			throw new RuntimeException("Please enter correct browser name!");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(urlPage);

		return driver;

	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	@BeforeSuite(alwaysRun = true)
	public void deleteAllFilesInReportNGScreenshot() {
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + File.separator + "target" + File.separator + "allure-json"
					+ File.separator;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].getName().contains("-result.json")
						|| listOfFiles[i].getName().contains("-attachment")
						|| listOfFiles[i].getName().contains("-container.json")) {
					if (listOfFiles[i].isFile()) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	protected void cleanDriverInstance() {
		try {
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
				log.info("Close driver instance");
			}
		} catch (NoSuchSessionException e) {
			e.printStackTrace();
		}
	}

	@AfterSuite(alwaysRun = true)
	protected void clenExecutablleDriver() {
		String cmd = "";

		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			if (driver.toString().contains("chrome")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driver.toString().contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driver.toString().contains("edge")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driver.toString().toLowerCase().contains("safari")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq safaridriver*\"";
				} else {
					cmd = "pkill safaridriver";
				}
			} else if (driver.toString().contains("H_CHROME")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driver.toString().contains("H_FIREFOX")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			}
			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
			log.info("Run command line");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
