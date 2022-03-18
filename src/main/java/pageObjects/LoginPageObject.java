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
	
	@Step("Enter {0} email and {1} password on 'Login' form")
	public void enterEmailAndPasswordInloginForm(String emailValue, String passwordValue ) {
		enterValueIntoTextboxByLabel(driver, "Email", emailValue);
		enterValueIntoTextboxByLabel(driver, "Password", passwordValue);
	}

	@Step("Is Aspire app Logo displayed")
	public boolean isAspireAppLogoDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGO_ON_LOGIN_PAGE);
		return isElementDisplayed(driver, LoginPageUI.LOGO_ON_LOGIN_PAGE);
	}

}
