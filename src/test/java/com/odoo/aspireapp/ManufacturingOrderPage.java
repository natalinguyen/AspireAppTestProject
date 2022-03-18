package com.odoo.aspireapp;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import drivenData.AspireAppData;
import io.qameta.allure.Description;
import pageObjects.HomePageObject;
import pageObjects.InventoryPageObject;
import pageObjects.LoginPageObject;
import pageObjects.ManufacturingPageObject;
import pageObjects.PageGenerateManager;
import pageObjects.ProductPageObject;

public class ManufacturingOrderPage extends BaseTest {

	WebDriver driver;
	private String productName, manufacturingOderId, quantityQty_producingOnManufacturingOrderPage,
			quantityProduct_uom_idOnManufacturingOrderPage;
	String productNameInComponentTable, fromInComponentTable, toConsumeInComponentTable,
			productOnManufacturingOrderPage, quantityProduct_qtyOnManufacturingOrderPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlPage) {
		driver = getDriverBrowser(browserName, urlPage);

		driverData = AspireAppData.getUserDataTest();
		productName = "MacbookPro" + randomNumber();

		loginPage = PageGenerateManager.getLoginPage(driver);
		log.info("TC_01_Pre-Condition - Step 01: Verify 'Aspire' logo displayed");
		verifyTrue(loginPage.isAspireAppLogoDisplayed());

		log.info("TC_01_Pre-Condition - Step 02: Log-in to web application with ");
		loginPage.enterEmailAndPasswordInloginForm(driverData.getLoginUserName(), driverData.getLoginPassword());
		loginPage.clickOnButton(driver, "Log in");
		homePage = PageGenerateManager.getHomePage(driver);

		log.info("TC_01_Pre-Condition - Step 03: Verify menu navigation bar displayed");
		verifyTrue(homePage.isMenuNavbarDisplayed());

		log.info("TC_01_Pre-Condition - Step 04: Navigate to 'Inventory' page");
		homePage.clickOnAListBox("Inventory");
		inventoryPage = PageGenerateManager.getInventoryPage(driver);
		verifyTrue(inventoryPage.isMainNavBarDisplayed(driver, "Inventory"));

		log.info("TC_01_Pre-Condition - Step 05: Click 'Products' sub menu from 'Products' main menu");
		inventoryPage.clickOnSubMenuFromMainMenu("Products", "Products");
		productPage = PageGenerateManager.getProductPage(driver);

		log.info("TC_01_Pre-Condition - Step 06: Click on 'Create' button");
		productPage.clickOnButton(driver, "Create");

		log.info("TC_01_Pre-Condition - Step 07: Enter value in 'Product name' textbox");
		productPage.enterValueInTextBoxFollowingH1ByLabel("Product Name", productName);

		log.info("TC_01_Pre-Condition - Step 08: Select item from 'Product Type' dropdown");
		productPage.selectItemFromDefaultDropdownOnProductPage("Product Type",
				driverData.getProductTypeOnProductPage());

		log.info("TC_01_Pre-Condition - Step 09: Select item from 'Unit Of Measure' dropdown");
		productPage.selectItemInUnitOfMeasureDropdownOnProductPage("ui-id-1", driverData.getuOMOnProductPage());
		productPage.selectItemInUnitOfMeasureDropdownOnProductPage("ui-id-1", driverData.getuOMOnProductPage());

		log.info("TC_01_Pre-Condition - Step 11: Enter value in 'Sale Price' textbox");
		productPage.enterValueIntoTextboxInTableByLabel("Sales Price", driverData.getSalePriceOnProductPage());

		log.info("TC_01_Pre-Condition - Step 12: Select 'All' from 'Product Category' dropdown");
		productPage.selectItemInProductCategoryDropdownOnProductPage("ui-id-3",
				driverData.getProductCategoryOnProductPage());

		log.info("TC_01_Pre-Condition - Step 13: Click 'Save' button");
		productPage.clickOnButton(driver, "Save");

		log.info("TC_01_Pre-Condition - Step 14: Verify information on 'Product detail' page");
		verifyEquals(productPage.getTextOfProductTypeOnProductDetailPage(), "Storable Product");
		verifyEquals(productPage.getTextOnProductDetailPage("Unit of Measure"), driverData.getuOMOnProductPage());
		verifyEquals(productPage.getTextOnProductDetailPage("Purchase UoM"), driverData.getuOMOnProductPage());
		verifyEquals(productPage.getTextOnProductDetailPage("Sales Price"),
				"$ " + driverData.getSalePriceOnProductPage());
		verifyEquals(productPage.getTextOnProductDetailPage("Product Category"),
				driverData.getProductCategoryOnProductPage());
		verifyEquals(productPage.getMessagePrettyBody(driver), driverData.getProductTemplateCreatedMessage());

		log.info("TC_01_Pre-Condition - Step 15: Click 'Update Quantity' button");
		productPage.clickOnButton(driver, "Update Quantity");

		log.info(

				"TC_01_Pre-Condition - Step 16: Get nocontent view displayed: 'Your stock is currently empty'");
		verifyTrue(productPage.isMessageOnUpdateQuantityDisplayed(driverData.getEmptyStockOnQuanityPage()));

		log.info("TC_01_Pre-Condition - Step 17: Click 'Create' button");
		productPage.clickOnButton(driver, "Create");

		log.info(

				"TC_01_Pre-Condition - Step 18: Enter value into 'Counted Quantity' textbox is larger than 10");
		productPage.updateQualityOfNewProductIsMoreThan10(productName);

		log.info("TC_01_Pre-Condition - Step 19: Click 'SAVE' button");
		productPage.clickOnButton(driver, "Save");

		log.info("TC_01_Pre-Condition - Step 20: Click 'Home' menu");
		productPage.clickOnHomeMenuIcon(driver);
		homePage = PageGenerateManager.getHomePage(driver);

	}

	@Description("Manufacturing Order page")
	@Test(invocationCount = 1)
	public void TC_01_Create_A_Manufacturing_Order() {

		log.info("TC_01_Create_A_Manufacturing_Order - Step 21:  Navigate to 'Manufacturing' feature");
		homePage.clickOnAListBox("Manufacturing");
		manufacturingPage = PageGenerateManager.getManufacturingPage(driver);

		log.info("TC_01_Create_A_Manufacturing_Order - Step 22: Click 'Create' button");
		manufacturingPage.clickOnButton(driver, "Create");

		log.info("TC_01_Create_A_Manufacturing_Order - Step 23: Enter and select a created product name");
		manufacturingPage.enterValueIntoTextboxFromDropdownByLabel(driver, "Product", productName);

		log.info("TC_01_Create_A_Manufacturing_Order - Step 24: Click 'Confirm' button");
		manufacturingPage.clickOnButton(driver, "Confirm");

		log.info("TC_01_Create_A_Manufacturing_Order - Step 25: Update quantity of product");
		manufacturingPage.enterValueIntoTextboxFromDropdownByLabel(driver, "Quantity",
				driverData.getQuantityOnMacfacturingOrderPage());

		log.info("TC_01_Create_A_Manufacturing_Order - Step 26: Add a product in component table");
		manufacturingPage.clickOnNavTabOnManuFacturingOrderPage("Components");
		manufacturingPage.clickOnAddAlineButtonOnManuFacturingOrderPage();
		manufacturingPage.enterValueIntoProductTextBoxOnComponentTable("Product", productName, "product_id");
		manufacturingPage.enterValueIntoTextboxOnComponentTable(productName,
				driverData.getConsumedOnMacfacturingOrderPage());

		log.info("TC_01_Create_A_Manufacturing_Order - Step 27: Click 'SAVE' button");
		manufacturingPage.clickOnButton(driver, "Save");

		log.info("TC_01_Create_A_Manufacturing_Order - Step 28: Get information on 'Manufacturing order detail' page");
		manufacturingOderId = manufacturingPage.getOrderIDOnManufacturingOrderPage();
		productOnManufacturingOrderPage = manufacturingPage.getTextOnManufacturingOrderPageByLabelAndSpan("Product");
		quantityQty_producingOnManufacturingOrderPage = manufacturingPage
				.getTextOnManufacturingOrderPageByLabelAndSpanName("Quantity", "qty_producing");
		quantityProduct_uom_idOnManufacturingOrderPage = manufacturingPage
				.getTextOnManufacturingOrderPageByLabelAndSpanName("Quantity", "product_uom_id");

		log.info("TC_01_Create_A_Manufacturing_Order - Step 29: Click 'Mark As Done' button");
		manufacturingPage.clickOnButton(driver, "Mark as Done");

		log.info("TC_01_Create_A_Manufacturing_Order - Step 30: Click 'Manufacturing' main menu");
		manufacturingPage.clickOnMenuBrandOnTheTopBar(driver, "Manufacturing");

		log.info("TC_01_Create_A_Manufacturing_Order - Step 31: Search " + manufacturingOderId);
		manufacturingPage.searchManufactoringOrderInSearchTextbox(manufacturingOderId);

		log.info(
				"TC_01_Create_A_Manufacturing_Order - Step 32: Verify information of productName, 'Quantity', 'UoM', 'Status'");

		verifyEquals(manufacturingPage.getValueInTableColumnNamePrecedingMethodAndRowIndex("Product", "1"),
				productName);

		verifyEquals(manufacturingPage.getValueInTableColumnNamePrecedingMethodAndRowIndex("Quantity", "1"),
				quantityQty_producingOnManufacturingOrderPage);

		verifyEquals(manufacturingPage.getValueInTableColumnNamePrecedingMethodAndRowIndex("UoM", "1"),
				quantityProduct_uom_idOnManufacturingOrderPage);

		verifyEquals(manufacturingPage.getValueInTableColumnNamePrecedingMethodAndRowIndex("State", "1"),
				driverData.getDoneStatus());
	}

	@Parameters({ "browser" })
	@AfterTest(alwaysRun = true)
	public void afterTest(String browser) {
		log.info("Browser is closed: " + browser);
		cleanDriverInstance();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(9000);

	}

	LoginPageObject loginPage;
	HomePageObject homePage;
	InventoryPageObject inventoryPage;
	ManufacturingPageObject manufacturingPage;
	ProductPageObject productPage;
	AspireAppData driverData;
}
