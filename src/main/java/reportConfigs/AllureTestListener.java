package reportConfigs;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import commons.BaseTest;
import io.qameta.allure.Attachment;

public class AllureTestListener implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Screenshot attachments for Allure
	@Attachment(value = "Screenshot of {0}", type = "image/png")
	public static byte[] saveScreenshotPNG(WebDriver driver) {
		return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Text attachments for Allure
	@Attachment(value = "Text attachment of {0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		try {
			Object testClass = iTestResult.getInstance();
			WebDriver driver = ((BaseTest) testClass).getDriver();
			if (driver instanceof WebDriver) {
				System.out.println("Screenshot captured of test case: " + getTestMethodName(iTestResult));
				saveScreenshotPNG(driver);

			}
			saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");

		} catch (NoSuchSessionException e) {
			Log.debug(e.getMessage());
		} catch (WebDriverException e) {
			Log.debug(e.getMessage());
		}
	}

	@Override
	public void onStart(ITestContext iTestContext) {
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	}

	@Override
	public void onFinish(ITestContext arg0) {

	}

	@Override
	public void onTestStart(ITestResult arg0) {
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("TestCase:" + getTestMethodName(iTestResult) + " succeed");
	}

}