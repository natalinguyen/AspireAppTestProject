package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.InventoryPageUI;

public class InventoryPageObject extends BasePage {
	WebDriver driver;

	public InventoryPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@Step("Is {0} menu displayed")
	public boolean isMainNavBarDisplayed(String mainMenu) {
		waitForElementVisible(driver, InventoryPageUI.DYNAMIC_MAIN_NAVIGATION_BY_TEXT, mainMenu);
		return isElementDisplayed(driver, InventoryPageUI.DYNAMIC_MAIN_NAVIGATION_BY_TEXT, mainMenu);
	}
	
	@Step("Click on {0} menu")
	public void clickOnMainMenu(String mainMenu) {
		waitForElementClickable(driver, InventoryPageUI .DYNAMIC_MAIN_MENU_BY_TEXT, mainMenu);
		clickOnElement(driver, InventoryPageUI .DYNAMIC_MAIN_MENU_BY_TEXT, mainMenu);
	}

	@Step("Click on {1} submenu from {0} main menu")
	public void clickOnSubMenuFromMainMenu(String mainMenu, String subMenu) {
		waitForElementClickable(driver, InventoryPageUI .DYNAMIC_MAIN_MENU_BY_TEXT, mainMenu);
		clickOnElement(driver, InventoryPageUI .DYNAMIC_MAIN_MENU_BY_TEXT, mainMenu);
		
		waitForElementClickable(driver, InventoryPageUI .DYNAMIC_SUB_MAIN_MENU_BY_MAINMENU_TEXT_AND_SUB_MENU_TEXT, mainMenu, subMenu);
		clickOnElement(driver, InventoryPageUI .DYNAMIC_SUB_MAIN_MENU_BY_MAINMENU_TEXT_AND_SUB_MENU_TEXT, mainMenu, subMenu);
	}

}
