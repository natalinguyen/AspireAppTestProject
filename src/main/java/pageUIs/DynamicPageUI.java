package pageUIs;

public class DynamicPageUI {
	public static final String HOME_MENU_ICON = "xpath=//a[@title='Home menu']";
	public static final String DYNAMIC_NAVIGATION_TITLE = "xpath=//ol[@role='navigation']//span";
	public static final String DYNAMIC_CUSTOM_DROPDOWN = "xpath=//ul[@id='%s']/li/a";
	public static final String DYNAMIC_BUTTON_BY_STRING = "xpath=//button[contains(string(),'%s')]";
	public static final String DYNAMIC_GET_MESSAGE_PRETTY_BODY= "xpath=//div[@class='o_Message_prettyBody']/p";

	public static final String DYNAMIC_INPUT_TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::input";
	public static final String DYNAMIC_H1_INPUT_TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::h1//input";
	public static final String DYNAMIC_MAIN_NAVIGATION_BY_TEXT = "xpath=//nav[@class='o_main_navbar']/a[text()='%s']";
	public static final String DYNAMIC_MAIN_MENU_BY_TEXT = "xpath=//div[@class='o_menu_sections']//span[text()='%s']";
	public static final String DYNAMIC_INPUT_TEXTBOX_FROM_DROPDOWN_BY_LABEL = "xpath=//label[text()='%s']/parent::td/following-sibling::td//input";
	public static final String DYNAMIC_BUTTTON_ICON_FROM_DROPDOWN_LABEL = "xpath=//label[text()='%s']/parent::td/following-sibling::td//a";
	public static final String DYNAMIC_SUB_MAIN_MENU_BY_MAINMENU_TEXT_AND_SUB_MENU_TEXT = "xpath=//div[@class='o_menu_sections']//span[text()='%s']/parent::button/following-sibling::div/a[text()='%s']";
	public static final String DYNAMIC_COLUMN_INDEX_PRECEDING_ON_TABLE_BY_HEADER_NAME = "xpath=//th[contains(string(),'%s')]/preceding-sibling::th";
	public static final String DYNAMIC_MENU_BRAND_ON_TOP_BAR = "xpath=//a[@class='dropdown-item o_menu_brand' and text()='%s']";
}
