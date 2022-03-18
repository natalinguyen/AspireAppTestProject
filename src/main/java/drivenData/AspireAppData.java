package drivenData;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class AspireAppData {

	public static AspireAppData getUserDataTest() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(
					new File(GlobalConstants.WORKING_DIR + "/src/main/java/drivenData/dataOnAspireApp.json"),
					AspireAppData.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getLoginUserName() {
		return loginUserName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public String getProductTypeOnProductPage() {
		return productPage.productTypeOnProductPage;
	}

	public String getuOMOnProductPage() {
		return productPage.uOMOnProductPage;
	}

	public String getSalePriceOnProductPage() {
		return productPage.salePriceOnProductPage;
	}

	public String getProductCategoryOnProductPage() {
		return productPage.productCategoryOnProductPage;
	}

	public String getProductTemplateCreatedMessage() {
		return productPage.productTemplateCreatedMessage;
	}

	public String getEmptyStockOnQuanityPage() {
		return productPage.emptyStockOnQuanityPage;
	}

	public String getQuantityOnMacfacturingOrderPage() {
		return manufacturingOrderPage.quantityOnMacfacturingOrderPage;
	}

	public String getConsumedOnMacfacturingOrderPage() {
		return manufacturingOrderPage.consumedOnMacfacturingOrderPage;
	}

	public String getDoneStatus() {
		return manufacturingOrderPage.doneStatus;
	}

	
	@JsonProperty("loginUserName")
	private String loginUserName;

	@JsonProperty("loginPassword")
	private String loginPassword;

	@JsonProperty("ProductPage")
	ProductPage productPage;

	static class ProductPage {
		@JsonProperty("productTypeOnProductPage")
		private String productTypeOnProductPage;
		
		@JsonProperty("uOMOnProductPage")
		private String uOMOnProductPage;
		
		@JsonProperty("salePriceOnProductPage")
		private String salePriceOnProductPage;
		
		@JsonProperty("productCategoryOnProductPage")
		private String productCategoryOnProductPage;
		
		@JsonProperty("productTemplateCreatedMessage")
		private String productTemplateCreatedMessage;

		@JsonProperty("emptyStockOnQuanityPage")
		private String emptyStockOnQuanityPage;

	}

	@JsonProperty("ManufacturingOrderPage")
	ManufacturingOrderPage manufacturingOrderPage;

	static class ManufacturingOrderPage {
		@JsonProperty("quantityOnMacfacturingOrderPage")
		private String quantityOnMacfacturingOrderPage;
		
		@JsonProperty("consumedOnMacfacturingOrderPage")
		private String consumedOnMacfacturingOrderPage;
		
		@JsonProperty("doneStatus")
		private String doneStatus;
	}

}
