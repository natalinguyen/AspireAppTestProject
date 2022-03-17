package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@Step("Is menu bar displayed")
	public boolean isMenuNavbarDisplayed() {
		waitForElementVisible(driver, HomePageUI.MENU_NAV_BAR_DISPLAYED);
		return isElementDisplayed(driver, HomePageUI.MENU_NAV_BAR_DISPLAYED);
	}

	@Step("Click {0} box")
	public void clickOnAListBox(String boxName) {
		waitForElementClickable(driver, HomePageUI.LISTBOX_DISPLAYED, boxName);
		clickOnElement(driver, HomePageUI.LISTBOX_DISPLAYED, boxName);
	}

}
