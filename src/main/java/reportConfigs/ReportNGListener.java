package reportConfigs;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import commons.BaseTest;

public class ReportNGListener extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Log.info("---------" + result.getName() + " STARTED test---------");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("---------" + result.getName() + " SUCCESS test---------");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Log.info("---------" + result.getName() + " FAILURE test---------");
			System.setProperty("org.uncommons.reportng.escape-output", "false");

			Object testClass = result.getInstance();
			WebDriver webDriver = ((BaseTest) testClass).getDriver();
			String screenshotPath = captureScreenshot(webDriver, result.getName());
			Reporter.getCurrentTestResult();
			Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///"
					+ screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
			Reporter.setCurrentTestResult(null);
		} catch (NoSuchWindowException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	private String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("");
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenPath = System.getProperty("user.dir") + "/ReportNGScreenshots/" + screenshotName + "_"
					+ formater.format(calendar.getTime()) + ".png";
			FileUtils.copyFile(source, new File(screenPath));
			return screenPath;
		} catch (IOException e) {
			Log.debug("Exception while taking screenshot: " + e.getMessage());
			return e.getMessage();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Log.info("---------" + result.getName() + " SKIPPED test---------");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Log.info("---------" + result.getName() + " FAILED WITH SUCCESS PERCENTAGE test ----------");

	}

	@Override
	public void onStart(ITestContext result) {
		Log.info("---------" + result.getName() + " STARTED test ----------");

	}

	@Override
	public void onFinish(ITestContext result) {
		Log.info("---------" + result.getName() + " FINISHED test---------");

	}

}
