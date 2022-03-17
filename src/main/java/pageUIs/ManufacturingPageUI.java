package pageUIs;

public class ManufacturingPageUI extends DynamicPageUI {

	public static final String DYNAMIC_CLICK_ON_TAB_ON_MANUFACTURING_ORDER_PAGE =  "xpath=//div[@class='o_notebook_headers']//li/a[text()='%s']";
	public static final String DYNAMIC_ADD_A_LINE_ON_MANUFACTURING_ORDER_PAGE =  "xpath=//div[@class='tab-content']/div[@class='tab-pane active']//tbody/tr/td/a";
	public static final String DYNAMIC_COLUMN_INDEX_FOLLOWING_ON_COMPONEBT_TABLE_BY_HEADER_NAME = "xpath=//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']//th[contains(string(),'%s')]/following-sibling::th";
	public static final String DYNAMIC_COLUMN_INDEX_PRECEDING_ON_COMPONEBT_TABLE_BY_HEADER_NAME = "xpath=//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']//th[contains(string(),'%s')]/preceding-sibling::th";
	public static final String DYNAMIC_COLUMN_INDEX_ON_COMPONEBT_TABLE_BY_HEADER_NAME = "xpath=//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']//th[contains(string(),'%s')]";
	public static final String DYNAMIC_ROW_INDEX_ON_COMPONENT_TABLE_BY_PRODUCT_TITLE = "xpath=//td[@title='%s']/parent::tr/preceding-sibling::tr";
	public static final String TOTAL_ROW_INDEX_ON_COMPONENT_TABLE_BY_PRODUCT_TITLE = "xpath=//td/a[text()='Add a line']/ancestor::tr/preceding-sibling::tr";
	public static final String DYNAMIC_TEXTBOX_ON_COMPONENT_TABLE_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tr[%s]/td[%s]/input";
	public static final String DYNAMIC_PRODUCT_TEXTBOX_ON_COMPONENT_TABLE_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tr[%s]/td[%s]//input";
	public static final String GET_H1_TEXT_MANUFACURING_ORDER_ID = "xpath=//h1//span";
	public static final String GET_TEXT_MANUFACURING_ORDER_PAGE_BY_LABEL_AND_SPAN = "xpath=//div[@class='o_group']//label[text()='%s']/parent::td/following-sibling::td//span";
	public static final String GET_TEXT_MANUFACURING_ORDER_PAGE_BY_LABEL_AND_SPAN_NAME = "xpath=//div[@class='o_group']//label[text()='%s']/parent::td/following-sibling::td//span[@name='%s']";
	public static final String GET_TEXT_OF_PRODUCT_ID_ON_MANUFACURING_ORDER_PAGE = "xpath=//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']//tbody/tr[%s]/td[%s]";
	public static final String STATUS_TO_CLOSE_DONE_ON_MANUFACURING_ORDER_PAGE = "xpath=//div[@class='o_Chatter_scrollPanel']//ul[@class='o_Message_trackingValues']/li[contains(string(),'To Close')  and contains(string(),'Done')]";
	public static final String SEARCH_TEXTBOX_MANUFACURING_ORDER_PAGE = "xpath=//input[@class='o_searchview_input']";
	public static final String SEARCH_ITEM_SELECTION_MANUFACURING_ORDER_PAGE = "xpath=//div[@class='o_cp_searchview']//ul/li/a";
	public static final String SEARCH_ITEM_SELECTION_COMPONENT_TABLE = "xpath=//ul[not(@style='display: none;')]/li[@class='ui-menu-item']/a";
	public static final String TEXTBOX_ON_COMPONENT_TABLE = "xpath=//td[@name='%s']";
	public static final String DELETE_ICON_ON_SEARCH_ITEM_IN_SEARCH_TEXTBOX = "xpath=//div[@class='o_searchview_facet']//div[contains(string(), 'Manufacturing Orders')]/following-sibling::i";
	public static final String CONSUMED_TEXTBOX_ON_COMPONENT_TABLE = "xpath=//td[@title='%s']/following-sibling::td[@name='quantity_done']/input";
//	public static final String PRODUCT_TEXTBOX_ON_COMPONENT_TABLE = "xpath=(//tbody[@class='ui-sortable']//div[@class='o_field_many2one_selection']//input)[1]";
	public static final String PRODUCT_ID_TEXTBOX_ON_COMPONENT_TABLE = "xpath=//td[@name='product_id']//div[@class='o_field_many2one_selection']//input[@type='text']";
	public static final String PRODUCT_UOM_TEXTBOX_ON_COMPONENT_TABLE = "xpath=//td[@name='product_uom']//div[@class='o_field_many2one_selection']//input[@type='text']";
	public static final String QUANTITY_DONE_TEXTBOX_ON_COMPONENT_TABLE = "xpath=//td[@name='quantity_done']//input[@type='text']";
	

	
	//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']//th[contains(string(),'Product')]/following-sibling::th


	//input[@name='product_qty' and  not(@data-original-title)]
	//input[@name='product_qty' and  not(@data-original-title)]/following-sibling::div//input
	//div[@class='tab-pane active']//a[text()='Add a line']
	//a[text()='Components']
	//span[@name='qty_producing']
	//span[@name='qty_producing']/parent::div/following-sibling::span[@name='product_qty']
	//span[@name='product_uom_id']/span
}
