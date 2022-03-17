package pageUIs;

public class ProductPageUI extends DynamicPageUI{
	public static final String GET_TEXT_FOLLOWING_H1_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::h1//span";
	public static final String ITEMS_LOCATION_IN_CUSTOM_DROPDOWN = "xpath=//ul[contains(@style, 'display: none; top: 203px; left: 44.4531px; width: 102.961px')]/li/a";
	public static final String TEXTBOX_FOLLOWING_H1_BY_LABEL = "xpath=//label[text()='%s']//following-sibling::h1//input";
	public static final String DYNAMIC_BUTTON_ON_PRODUCT_PAGE_BY_SPAN_TEXT = "xpath=//button/span[text()='%s']";
	public static final String DYNAMIC_IS_NO_CONTENT_MESSAGE_DISPLAYED = "xpath=//div[@class='o_view_nocontent']//p[contains(string(), '%s')]";
	public static final String DYNAMIC_ENTER_AND_SELECT_ITEM_FROM_DROPDOWN = "xpath=//div[@name='%s']//input";
	public static final String DYNAMIC_SELECT_RANDROM_ITEM_IN_DROPDOWN_BY_LABEL = "xpath=//label[text()='%s']/parent::td/following-sibling::td/select";
	public static final String DYNAMIC_SELECT_RANDROM_ITEM_IN_DEFAULT_DROPDOWN_BY_LABEL = "xpath=//label[text()='%s']/parent::td/following-sibling::td/select/option";
	public static final String DYNAMIC_SELECT_RANDROM_ITEM_IN_UNIT_OF_MEASURE_DROPDOWN = "xpath=//label[text()='Unit of Measure']/parent::td/following-sibling::td//input";
	public static final String DYNAMIC_SELECT_RANDROM_ITEM_IN_PRODUCT_CATEGORY_DROPDOWN = "xpath=//label[text()='Product Category']/parent::td/following-sibling::td//input";
	public static final String DYNAMIC_IS_ITEMS_ON_PRODUCT_PAGE_DISPLAYED = "xpath=//label[text()='%s']/parent::td/following-sibling::td//span[contains(string(), '%s')]";
	public static final String DYNAMIC_GET_TEXT_FROM_DROPDOWN = "xpath=//label[text()='%s']/parent::td/following-sibling::td//span";
	public static final String DYNAMIC_GET_TEXT_OF_PRODUCT_TYPE_DROPDOWN = "xpath=//label[text()='Product Type']/parent::td/following-sibling::td/span";
	public static final String DYNAMIC_INPUT_VALUE_IN_TEXTBOX_IN_TABLE_ON_PRODUCT_DETAIL_PAGE = "xpath=//label[text()='%s']/parent::td/following-sibling::td//input";
	public static final String DYNAMIC_CLICK_LOCATION_TEXTBOX_IN_TABLE_ON_UPDATE_QUANTITY_PAGE_BY_PRODUCT_NAME = "xpath=//tr/td/a[text()='%s']/parent::td/preceding-sibling::td[@name='location_id']//input";
	public static final String DYNAMIC_ENTER_VALUE_IN_TEXTBOX_IN_TABLE_ON_UPDATE_QUANTITY_PAGE_BY_PRODUCT_NAME = "xpath=//tr/td/a[text()='%s']/parent::td/following-sibling::td//input[@name='inventory_quantity']";
}
