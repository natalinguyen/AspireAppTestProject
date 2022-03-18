package commons;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pageUIs.DynamicPageUI;
import pageUIs.InventoryPageUI;
import pageUIs.LoginPageUI;
import reportConfigs.Log;

public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public By getLocator(String locatorType) {
		By by = null;

		if (locatorType.startsWith("id=") | locatorType.startsWith("Id=") | locatorType.startsWith("ID=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("name=") | locatorType.startsWith("Name=")
				| locatorType.startsWith("NAME=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("className=") | locatorType.startsWith("ClassName=")
				| locatorType.startsWith("CLASSNAME=")) {
			by = By.className(locatorType.substring(10));
		} else if (locatorType.startsWith("tagName=") | locatorType.startsWith("TagName=")
				| locatorType.startsWith("TAGNAME=")) {
			by = By.tagName(locatorType.substring(8));
		} else if (locatorType.startsWith("linkText=") | locatorType.startsWith("LinkText=")
				| locatorType.startsWith("LINKTEXT=")) {
			by = By.linkText(locatorType.substring(9));
		} else if (locatorType.startsWith("css=") | locatorType.startsWith("Css=") | locatorType.startsWith("CSS=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") | locatorType.startsWith("Xpath=")
				| locatorType.startsWith("XPATH=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("LocatorType is not supported");
		}
		return by;
	}

	public String getDynamicLocator(String locator, String[] params) {
		return String.format(locator, (Object[]) params);
	}

	public WebElement getElementByLocator(WebDriver driver, String locator) {
		return driver.findElement(getLocator(locator));

	}

	public List<WebElement> getElementsByLocator(WebDriver driver, String locator) {
		return driver.findElements(getLocator(locator));
	}

	public WebElement getElementByLocator(WebDriver driver, String locator, String... params) {
		return driver.findElement(getLocator(getDynamicLocator(locator, params)));

	}

	public List<WebElement> getElementsByLocator(WebDriver driver, String locator, String... params) {
		return driver.findElements(getLocator(getDynamicLocator(locator, params)));
	}

	public void openURLPage(WebDriver driver, String urlPage) {
		try {
			driver.get(urlPage);
		} catch (Exception e) {
			Log.debug(e.getMessage());

		}
	}

	public void refreshUrlPage(WebDriver driver) {
		try {
			driver.getCurrentUrl();
		} catch (Exception e) {
			Log.debug(e.getMessage());
		}
	}

	public Set<Cookie> getAllCookies(WebDriver driver){
		return driver.manage().getCookies();
	}
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		new Actions(driver).sendKeys(getElementByLocator(driver, locator), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... params) {
		new Actions(driver).sendKeys(getElementByLocator(driver, getDynamicLocator(locator, params)), key).perform();
	}

	public void enterValueToTextbox(WebDriver driver, String locator, String value) {
		try {
			highlightElement(driver, locator);
			getElementByLocator(driver, locator).clear();
			getElementByLocator(driver, locator).sendKeys(value);
		} catch (Exception e) {
			Log.debug(e.getMessage());
		}
	}

	public void sendKeysToTextbox(WebDriver driver, String locator, Keys key) {
		try {
			highlightElement(driver, locator);
			getElementByLocator(driver, locator).clear();
			getElementByLocator(driver, locator).sendKeys(key);
		} catch (Exception e) {
			Log.debug(e.getMessage());
		}
	}

	public void sendKeysToElement(WebDriver driver, String locator, Keys key, String... params) {
		try {
			highlightElement(driver, locator, params);
			getElementByLocator(driver, getDynamicLocator(locator, params)).clear();
			getElementByLocator(driver, getDynamicLocator(locator, params)).sendKeys(key);
		} catch (Exception e) {
			Log.debug(e.getMessage());
		}
	}

	public void enterValueToElement(WebDriver driver, String locator, String value, String... params) {
		try {
			highlightElement(driver, locator, params);
			getElementByLocator(driver, getDynamicLocator(locator, params)).clear();
			getElementByLocator(driver, getDynamicLocator(locator, params)).sendKeys(value);
		} catch (Exception e) {
			Log.debug(e.getMessage());
		}
	}

	public void clickOnElement(WebDriver driver, String locator) {
		try {
			highlightElement(driver, locator);
			getElementByLocator(driver, locator).click();
			sleepInSecond(1);
		} catch (Exception e) {
			Log.debug(e.getMessage());
		}
	}

	public void clickOnElement(WebDriver driver, String locator, String... params) {
		try {
			highlightElement(driver, locator, params);
			getElementByLocator(driver, getDynamicLocator(locator, params)).click();
			sleepInSecond(1);

		} catch (Exception e) {
			Log.debug(e.getMessage());
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		boolean status = true;
		try {
			element = getElementByLocator(driver, locator);
			if (element.isDisplayed()) {
				highlightElement(driver, locator);
				return status;
			}
		} catch (Exception e) {
			Log.debug(e.getMessage());

			status = false;
		}
		return status;
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
		boolean status = true;
		try {
			element = getElementByLocator(driver, getDynamicLocator(locator, params));
			if (element.isDisplayed()) {
				highlightElement(driver, locator, params);
				return status;
			}
		} catch (Exception e) {
			Log.debug(e.getMessage());

			status = false;
		}
		return status;
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		boolean status = true;
		try {
			element = getElementByLocator(driver, locator);
			if (element.isEnabled()) {
				highlightElement(driver, locator);
				return status;
			}
		} catch (Exception e) {
			Log.debug("Element is not enabled" + e.getMessage());
			status = false;
		}
		return status;
	}

	public boolean isElementEnabled(WebDriver driver, String locator, String... params) {

		boolean status = true;
		try {
			element = getElementByLocator(driver, getDynamicLocator(locator, params));
			if (element.isEnabled()) {
				highlightElement(driver, locator, params);
				return status;
			}
		} catch (Exception e) {
			Log.debug("Element is not enabled" + e.getMessage());
			status = false;
		}
		return status;
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		boolean status = true;
		try {
			element = getElementByLocator(driver, locator);
			if (element.isSelected()) {
				highlightElement(driver, locator);
				return status;
			}
		} catch (Exception e) {
			Log.debug("Element is not selected" + e.getMessage());
			status = false;
		}
		return status;
	}

	public boolean isElementSelected(WebDriver driver, String locator, String... params) {
		boolean status = true;
		try {
			element = getElementByLocator(driver, getDynamicLocator(locator, params));
			if (element.isSelected()) {
				highlightElement(driver, locator, params);
				return status;
			}
		} catch (Exception e) {
			Log.debug("Element is not selected" + e.getMessage());
			status = false;
		}
		return status;
	}

	public String getElementText(WebDriver driver, String locator) {
		highlightElement(driver, locator);
		return getElementByLocator(driver, locator).getText();
	}

	public String getElementText(WebDriver driver, String locator, String... params) {
		highlightElement(driver, locator, params);
		return getElementByLocator(driver, getDynamicLocator(locator, params)).getText();
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeParam) {
		highlightElement(driver, locator);
		return getElementByLocator(driver, locator).getAttribute(attributeParam);
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeParam, String... params) {
		highlightElement(driver, locator, params);
		return getElementByLocator(driver, getDynamicLocator(locator, params)).getAttribute(attributeParam);
	}

	public void selectDefaultDropdown(WebDriver driver, String locator, String selectedItem) {
		try {
			highlightElement(driver, locator);
			Select select = new Select(getElementByLocator(driver, locator));
			select.selectByVisibleText(selectedItem);
		} catch (Exception e) {
			Log.debug(e.getMessage());
		}
	}

	public void selectDefaultDropdown(WebDriver driver, String locator, String selectedItem, String... params) {
		try {
			highlightElement(driver, locator, params);
			Select select = new Select(getElementByLocator(driver, getDynamicLocator(locator, params)));
			select.selectByVisibleText(selectedItem);
		} catch (Exception e) {
			Log.debug(e.getMessage());
		}
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		getElementByLocator(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getLocator(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				jsExecutor.executeScript("arguments[0].click();", item);
				sleepInSecond(1);
				break;
			}
		}
	}

	public void selectItemInCustomDropdownWithoutParentLocator(WebDriver driver, String childItemLocator,
			String expectedItem, String... params) {

		explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(getLocator(getDynamicLocator(childItemLocator, params))));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				jsExecutor.executeScript("arguments[0].click();", item);
				sleepInSecond(1);
				break;

			}
		}
	}

	public void selectItemInCustomDropdownWithoutParentLocator(WebDriver driver, String childItemLocator,
			String expectedItem) {

		explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getLocator(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;

			}
		}
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem, String... params) {
		getElementByLocator(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(getLocator(getDynamicLocator(childItemLocator, params))));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getSelectedItemDropdown(WebDriver driver, String locator) {
		Select select = new Select(getElementByLocator(driver, locator));
		highlightElement(driver, locator);
		return select.getFirstSelectedOption().getText();
	}

	public String getSelectedItemDropdown(WebDriver driver, String locator, String... params) {
		Select select = new Select(getElementByLocator(driver, getDynamicLocator(locator, params)));
		highlightElement(driver, locator, params);
		return select.getFirstSelectedOption().getText();
	}

	public int getElementSize(WebDriver driver, String locator, String... params) {
		List<WebElement> elements = getElementsByLocator(driver, getDynamicLocator(locator, params));
		return elements.size();
	}

	protected int getRandomNumberInBetween(int lowerBound, int upperBound) {
		Random random = new Random();
		return (random.nextInt(upperBound) + lowerBound);
	}

	public void sleepInSecond(long timeUnit) {
		try {
			Thread.sleep(1000 * timeUnit);
		} catch (InterruptedException e) {
			Log.debug(e.getMessage());

		}
	}

	public int getElementSize(WebDriver driver, String locator) {
		List<WebElement> elements = getElementsByLocator(driver, locator);
		return elements.size();
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElementByLocator(driver, locator));
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElementByLocator(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red;  border-style: dashed;");

		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void highlightElement(WebDriver driver, String locator, String... params) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElementByLocator(driver, getDynamicLocator(locator, params));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red;  border-style: dashed;");

		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		try {
			explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locator)));
		} catch (Exception e) {
			Log.debug(e.getMessage());
		}

	}

	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		try {
			explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(
					ExpectedConditions.visibilityOfElementLocated(getLocator(getDynamicLocator(locator, params))));
		} catch (Exception e) {
			Log.debug("Element doesn't exist" + e.getMessage());
		}
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		try {
			explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getLocator(locator)));
		} catch (Exception e) {
			Log.debug("Element is displaying" + e.getMessage());
		}
	}

	public void waitForElementInvisible(WebDriver driver, String locator, String... params) {
		try {
			explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(
					ExpectedConditions.invisibilityOfElementLocated(getLocator(getDynamicLocator(locator, params))));
		} catch (Exception e) {
			Log.debug("Element is displaying" + e.getMessage());
		}
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		try {
			explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.elementToBeClickable(getLocator(locator)));
		} catch (Exception e) {
			Log.debug("Element is not clickable" + e.getMessage());
		}
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		try {
			explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.elementToBeClickable(getLocator(getDynamicLocator(locator, params))));
		} catch (Exception e) {
			Log.debug("Element is not clickable" + e.getMessage());
		}
	}

	public void waitForElementPresence(WebDriver driver, String locator) {
		try {
			explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locator)));
		} catch (Exception e) {
			Log.debug("wait For Element Presence" + e.getMessage());
		}
	}

	public void waitForElementPresence(WebDriver driver, String locator, String... params) {
		try {
			explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait
					.until(ExpectedConditions.presenceOfElementLocated(getLocator(getDynamicLocator(locator, params))));
		} catch (Exception e) {
			Log.debug("wait For Element Presence" + e.getMessage());
		}
	}

	@Step("Click on {1} button")
	public void clickOnButton(WebDriver driver, String buttonName) {
		waitForElementClickable(driver, LoginPageUI.DYNAMIC_BUTTON_BY_STRING, buttonName);
		clickOnElement(driver, LoginPageUI.DYNAMIC_BUTTON_BY_STRING, buttonName);

	}

	@Step("Enter {2} in {1} text box")
	public void enterValueIntoTextboxByLabel(WebDriver driver, String labelName, String value) {
		waitForElementVisible(driver, LoginPageUI.DYNAMIC_INPUT_TEXTBOX_BY_LABEL, labelName);
		enterValueToElement(driver, LoginPageUI.DYNAMIC_INPUT_TEXTBOX_BY_LABEL, value, labelName);
	}

	@Step("Is {1} main menu displayed")
	public boolean isMainNavBarDisplayed(WebDriver driver, String mainMenu) {
		waitForElementVisible(driver, InventoryPageUI.DYNAMIC_MAIN_NAVIGATION_BY_TEXT, mainMenu);
		return isElementDisplayed(driver, InventoryPageUI.DYNAMIC_MAIN_NAVIGATION_BY_TEXT, mainMenu);
	}

	@Step("Click on Home Menu icon")
	public void clickOnHomeMenuIcon(WebDriver driver) {
		waitForElementClickable(driver, DynamicPageUI.HOME_MENU_ICON);
		clickOnElement(driver, DynamicPageUI.HOME_MENU_ICON);
	}

	@Step("Enter and select {2} value into {1} dropdown")
	public void enterValueIntoTextboxFromDropdownByLabel(WebDriver driver, String labelName, String value) {
		waitForElementVisible(driver, DynamicPageUI.DYNAMIC_INPUT_TEXTBOX_FROM_DROPDOWN_BY_LABEL, labelName);
		enterValueToElement(driver, DynamicPageUI.DYNAMIC_INPUT_TEXTBOX_FROM_DROPDOWN_BY_LABEL, value, labelName);
	}

	@Step("Click on {1}  menu")
	public void clickOnMenuBrandOnTheTopBar(WebDriver driver, String menuName) {
		waitForElementClickable(driver, DynamicPageUI.DYNAMIC_MENU_BRAND_ON_TOP_BAR, menuName);
		clickOnElement(driver, DynamicPageUI.DYNAMIC_MENU_BRAND_ON_TOP_BAR, menuName);
	}

	WebElement element;
	JavascriptExecutor jsExecutor;
	WebDriverWait explicitWait;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

}
