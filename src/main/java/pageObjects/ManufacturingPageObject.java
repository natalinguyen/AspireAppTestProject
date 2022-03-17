package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.ManufacturingPageUI;

public class ManufacturingPageObject extends BasePage {
	WebDriver driver;

	public ManufacturingPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	
	@Step("Click on {0} tab on 'Manufacturing order' page")
	public void clickOnNavTabOnManuFacturingOrderPage(String tabName) {
		waitForElementClickable(driver, ManufacturingPageUI.DYNAMIC_CLICK_ON_TAB_ON_MANUFACTURING_ORDER_PAGE, tabName);
		clickOnElement(driver, ManufacturingPageUI.DYNAMIC_CLICK_ON_TAB_ON_MANUFACTURING_ORDER_PAGE, tabName);
	}

	@Step("Click on 'Add a line' button on 'Manufacturing order' page")
	public void clickOnAddAlineButtonOnManuFacturingOrderPage() {
		waitForElementClickable(driver, ManufacturingPageUI.DYNAMIC_ADD_A_LINE_ON_MANUFACTURING_ORDER_PAGE);
		clickOnElement(driver, ManufacturingPageUI.DYNAMIC_ADD_A_LINE_ON_MANUFACTURING_ORDER_PAGE);
	}

	@Step("Enter {1} in {0} textbox")
	public void enterValueIntoTextboxOnComponentTable(String productName, String consumedNumber) {
		getElementByLocator(driver,ManufacturingPageUI.PRODUCT_ID_TEXTBOX_ON_COMPONENT_TABLE).sendKeys(Keys.TAB );
		getElementByLocator(driver,ManufacturingPageUI.PRODUCT_UOM_TEXTBOX_ON_COMPONENT_TABLE).sendKeys(Keys.TAB );
		getElementByLocator(driver, ManufacturingPageUI.QUANTITY_DONE_TEXTBOX_ON_COMPONENT_TABLE).sendKeys(consumedNumber);
	}

	@Step("Enter and select {1} at {0} headerName")
	public void enterValueIntoProductTextBoxOnComponentTable(String headerName, String value, String nameID) {
		int columnIndex = getElementSize(driver,
				ManufacturingPageUI.DYNAMIC_COLUMN_INDEX_ON_COMPONEBT_TABLE_BY_HEADER_NAME, headerName);
		int rowIndex = getElementSize(driver, ManufacturingPageUI.TOTAL_ROW_INDEX_ON_COMPONENT_TABLE_BY_PRODUCT_TITLE);

		waitForElementVisible(driver,
				ManufacturingPageUI.DYNAMIC_PRODUCT_TEXTBOX_ON_COMPONENT_TABLE_BY_COLUMN_INDEX_AND_ROW_INDEX,
				String.valueOf(rowIndex), String.valueOf(columnIndex));
		enterValueToElement(driver,
				ManufacturingPageUI.DYNAMIC_PRODUCT_TEXTBOX_ON_COMPONENT_TABLE_BY_COLUMN_INDEX_AND_ROW_INDEX, value,
				String.valueOf(rowIndex), String.valueOf(columnIndex));
		selectItemInCustomDropdownWithoutParentLocator(driver,
				ManufacturingPageUI.SEARCH_ITEM_SELECTION_COMPONENT_TABLE, value);
	}

	@Step("Enter {1} at {0} textbox")
	public void enterValueIntoTextboxInTableByLabel(String labelName, String value) {
		waitForElementVisible(driver, ManufacturingPageUI.DYNAMIC_INPUT_TEXTBOX_FROM_DROPDOWN_BY_LABEL, labelName);
		enterValueToElement(driver, ManufacturingPageUI.DYNAMIC_INPUT_TEXTBOX_FROM_DROPDOWN_BY_LABEL, value, labelName);
	}

	@Step("Get value in table at {0} headername and {1} rowindex")
	public String getValueInTableColumnNameFollowingMethodAndRowIndex(String headerName, String rowIndex) {
		int columnIndex = getElementSize(driver,
				ManufacturingPageUI.DYNAMIC_COLUMN_INDEX_FOLLOWING_ON_COMPONEBT_TABLE_BY_HEADER_NAME, headerName) + 1;

		waitForElementVisible(driver, ManufacturingPageUI.GET_TEXT_OF_PRODUCT_ID_ON_MANUFACURING_ORDER_PAGE, rowIndex,
				String.valueOf(columnIndex));
		return getElementText(driver, ManufacturingPageUI.GET_TEXT_OF_PRODUCT_ID_ON_MANUFACURING_ORDER_PAGE, rowIndex,
				String.valueOf(columnIndex));

	}

	@Step("Get value in table at {0} headername and {1} rowindex ")
	public String getValueInTableColumnNamePrecedingMethodAndRowIndex(String headerName, String rowIndex) {
		int columnIndex = getElementSize(driver,
				ManufacturingPageUI.DYNAMIC_COLUMN_INDEX_PRECEDING_ON_COMPONEBT_TABLE_BY_HEADER_NAME, headerName) + 1;

		waitForElementVisible(driver, ManufacturingPageUI.GET_TEXT_OF_PRODUCT_ID_ON_MANUFACURING_ORDER_PAGE, rowIndex,
				String.valueOf(columnIndex));
		return getElementText(driver, ManufacturingPageUI.GET_TEXT_OF_PRODUCT_ID_ON_MANUFACURING_ORDER_PAGE, rowIndex,
				String.valueOf(columnIndex));
	}

	@Step("Get text on Manufacturing Order page at {0}")
	public String getTextOnManufacturingOrderPageByLabelAndSpan(String labelName) {
		waitForElementVisible(driver, ManufacturingPageUI.GET_TEXT_MANUFACURING_ORDER_PAGE_BY_LABEL_AND_SPAN,
				labelName);
		return getElementText(driver, ManufacturingPageUI.GET_TEXT_MANUFACURING_ORDER_PAGE_BY_LABEL_AND_SPAN,
				labelName);
	}

	@Step("Get orderID on Manufacturing Order page")
	public String getOrderIDOnManufacturingOrderPage() {
		waitForElementVisible(driver, ManufacturingPageUI.GET_H1_TEXT_MANUFACURING_ORDER_ID);
		return getElementText(driver, ManufacturingPageUI.GET_H1_TEXT_MANUFACURING_ORDER_ID);
	}

	@Step("Get text on Manufacturing Order page at {0}")
	public String getTextOnManufacturingOrderPageByLabelAndSpanName(String labelName, String spanName) {
		waitForElementVisible(driver, ManufacturingPageUI.GET_TEXT_MANUFACURING_ORDER_PAGE_BY_LABEL_AND_SPAN_NAME,
				labelName, spanName);
		return getElementText(driver, ManufacturingPageUI.GET_TEXT_MANUFACURING_ORDER_PAGE_BY_LABEL_AND_SPAN_NAME,
				labelName, spanName);
	}

	@Step("Search {0} in Search textbox")
	public void searchManufactoringOrderInSearchTextbox(String searchItem) {
		waitForElementClickable(driver, ManufacturingPageUI.DELETE_ICON_ON_SEARCH_ITEM_IN_SEARCH_TEXTBOX);
		clickOnElement(driver, ManufacturingPageUI.DELETE_ICON_ON_SEARCH_ITEM_IN_SEARCH_TEXTBOX);

		enterValueToTextbox(driver, ManufacturingPageUI.SEARCH_TEXTBOX_MANUFACURING_ORDER_PAGE, searchItem);

		selectItemInCustomDropdownWithoutParentLocator(driver,
				ManufacturingPageUI.SEARCH_ITEM_SELECTION_MANUFACURING_ORDER_PAGE,
				"Search Manufacturing Order for: " + searchItem);
	}
}
