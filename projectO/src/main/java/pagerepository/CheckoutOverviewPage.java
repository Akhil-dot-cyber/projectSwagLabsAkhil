package pagerepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

	
	// 1. WebElement Identification and Declaration

		@FindBy(id = "finish")
		private WebElement finishbtn;
		
		@FindBy(className = "inventory_item_name")
		private List<WebElement> itemNames;

		@FindBy(className = "inventory_item_price")
		private List<WebElement> itemPrices;

		@FindBy(className = "cart_quantity")
		private List<WebElement> itemQuantities;


		// 2 .WebElement Initialization

		public CheckoutOverviewPage(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}

		// 3. WebElement Utilization

		public WebElement getfinishbtn() {
			return finishbtn;
		}

		public List<WebElement> getItemNames() {
			return itemNames;
		}

		public List<WebElement> getItemPrices() {
			return itemPrices;
		}

		public List<WebElement> getItemQuantities() {
			return itemQuantities;
		}


	
	
	
}
