package pageObjects;


import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.DynamicPageUI;
import pageUIs.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@Step("Get navigation title")
	public String getNavigationTitle() {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_NAVIGATION_TITLE);
		return getElementText(driver, ProductPageUI.DYNAMIC_NAVIGATION_TITLE);
	}

	@Step("Enter {1} at {0} text box")
	public void enterValueInTextBoxFollowingH1ByLabel(String labelName, String value) {
		waitForElementVisible(driver, ProductPageUI.TEXTBOX_FOLLOWING_H1_BY_LABEL, labelName);
		enterValueToElement(driver, ProductPageUI.TEXTBOX_FOLLOWING_H1_BY_LABEL, value, labelName);
	}

	@Step("Get content of {0} label")
	public String getTextFollowingH1ByLabel(String labelName) {
		waitForElementVisible(driver, ProductPageUI.GET_TEXT_FOLLOWING_H1_BY_LABEL, labelName);
		return getElementText(driver, ProductPageUI.GET_TEXT_FOLLOWING_H1_BY_LABEL, labelName);
	}

	@Step("Get message pretty body")
	public String getMessagePrettyBody(WebDriver driver) {
		scrollToElement(driver, ProductPageUI.DYNAMIC_GET_MESSAGE_PRETTY_BODY);
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_GET_MESSAGE_PRETTY_BODY);
		return getElementText(driver, ProductPageUI.DYNAMIC_GET_MESSAGE_PRETTY_BODY);
	}

	@Step("Click on {0} button on Product page")
	public void clickOnButtonOnProductPage(String spanButtonName) {
		waitForElementClickable(driver, ProductPageUI.DYNAMIC_BUTTON_ON_PRODUCT_PAGE_BY_SPAN_TEXT, spanButtonName);
		clickOnElement(driver, ProductPageUI.DYNAMIC_BUTTON_ON_PRODUCT_PAGE_BY_SPAN_TEXT, spanButtonName);
	}

	@Step("Is message on Update Quantity displayed: {0}")
	public boolean isMessageOnUpdateQuantityDisplayed(String contentMessage) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_IS_NO_CONTENT_MESSAGE_DISPLAYED, contentMessage);
		return isElementDisplayed(driver, ProductPageUI.DYNAMIC_IS_NO_CONTENT_MESSAGE_DISPLAYED, contentMessage);
	}

	@Step("Enter and select {1} item from {0} dropdown")
	public void enterAndSelectItemFromDropdown(String nameElement, String value) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_ENTER_AND_SELECT_ITEM_FROM_DROPDOWN, nameElement);
		enterValueToElement(driver, ProductPageUI.DYNAMIC_ENTER_AND_SELECT_ITEM_FROM_DROPDOWN, value, nameElement);
	}
	
	@Step("Select {1} value from  {0} dropdown On ProductPage")
	public void selectItemFromDefaultDropdownOnProductPage(String labelName, String selectedItem) {
		selectDefaultDropdown(driver, ProductPageUI.DYNAMIC_SELECT_RANDROM_ITEM_IN_DROPDOWN_BY_LABEL, selectedItem,
				labelName);
	}

	@Step("Select {1} value from  {0} dropdown On ProductPage")
	public void selectItemInUnitOfMeasureDropdownOnProductPage(String idValue, String selectedItem) {
		selectItemInCustomDropdown(driver, ProductPageUI.DYNAMIC_SELECT_RANDROM_ITEM_IN_UNIT_OF_MEASURE_DROPDOWN,
				DynamicPageUI.DYNAMIC_CUSTOM_DROPDOWN, selectedItem, idValue);
	}
	
	@Step("Select {1} value from  {0} dropdown On ProductPage")
	public void selectItemInProductCategoryDropdownOnProductPage(String idValue, String selectedItem) {
		selectItemInCustomDropdown(driver, ProductPageUI.DYNAMIC_SELECT_RANDROM_ITEM_IN_PRODUCT_CATEGORY_DROPDOWN,
				DynamicPageUI.DYNAMIC_CUSTOM_DROPDOWN, selectedItem, idValue);
	}

	@Step("Select {1} value from  {0} dropdown On ProductPage")
	public void selectItemInLocationDropdownOnUpdateQuantityPage(String productName, String selectedItem) {
		getElementByLocator(driver, ProductPageUI.DYNAMIC_CLICK_LOCATION_TEXTBOX_IN_TABLE_ON_UPDATE_QUANTITY_PAGE_BY_PRODUCT_NAME, productName).click();
		selectItemInCustomDropdownWithoutParentLocator(driver, ProductPageUI.ITEMS_LOCATION_IN_CUSTOM_DROPDOWN , selectedItem);
	}
	
	@Step("Get value of{0}  labelName")
	public String getTextOnProductDetailPage(String labelName) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_GET_TEXT_FROM_DROPDOWN, labelName);
		return getElementText(driver, ProductPageUI.DYNAMIC_GET_TEXT_FROM_DROPDOWN, labelName);
	}

	@Step("Get text of Product type on Product Details page")
	public String getTextOfProductTypeOnProductDetailPage() {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_GET_TEXT_OF_PRODUCT_TYPE_DROPDOWN);
		return getElementText(driver, ProductPageUI.DYNAMIC_GET_TEXT_OF_PRODUCT_TYPE_DROPDOWN);
	}

	@Step("Is {1} displayed at {0} label")
	public boolean isTextDisplayedOnProductDetailPage(String labelName, String spanText) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_IS_ITEMS_ON_PRODUCT_PAGE_DISPLAYED, labelName, spanText);
		return isElementDisplayed(driver, ProductPageUI.DYNAMIC_IS_ITEMS_ON_PRODUCT_PAGE_DISPLAYED, labelName, spanText);
	}

	@Step("Enter {1} value at {0} label")
	public void enterValueIntoTextboxInTableByLabel(String labelName, String value) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_INPUT_VALUE_IN_TEXTBOX_IN_TABLE_ON_PRODUCT_DETAIL_PAGE,
				labelName);
		enterValueToElement(driver, ProductPageUI.DYNAMIC_INPUT_VALUE_IN_TEXTBOX_IN_TABLE_ON_PRODUCT_DETAIL_PAGE, value, labelName);
	}

	@Step("Update quantity number is more than 10")
	public void updateQualityOfNewProductIsMoreThan10(String productName) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_ENTER_VALUE_IN_TEXTBOX_IN_TABLE_ON_UPDATE_QUANTITY_PAGE_BY_PRODUCT_NAME,
				productName);
		enterValueToElement(driver, ProductPageUI.DYNAMIC_ENTER_VALUE_IN_TEXTBOX_IN_TABLE_ON_UPDATE_QUANTITY_PAGE_BY_PRODUCT_NAME,
				String.valueOf(getRandomNumberInBetween(11, 9000)),  productName);
	}

	
}