package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerateManager {
	public PageGenerateManager(WebDriver driver) {
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static InventoryPageObject getInventoryPage(WebDriver driver) {
		return new InventoryPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static ManufacturingPageObject getManufacturingPage(WebDriver driver) {
		return new ManufacturingPageObject(driver);
	}
	
	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}
	
	

}
