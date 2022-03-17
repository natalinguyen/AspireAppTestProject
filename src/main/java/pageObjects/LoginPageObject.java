package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	@Step("Login app with {0} email and {1} password")
	public void loginFormWithEmailAndPassword(String emailValue, String passwordValue ) {
		enterValueIntoTextboxByLabel(driver, "Email", emailValue);
		enterValueIntoTextboxByLabel(driver, "Password", passwordValue);
		clickOnButton(driver, "Log in");
	}

	@Step("Is Aspire app Logo displayed")
	public boolean isAspireAppLogoDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGO_ON_LOGIN_PAGE);
		return isElementDisplayed(driver, LoginPageUI.LOGO_ON_LOGIN_PAGE);
	}

}
