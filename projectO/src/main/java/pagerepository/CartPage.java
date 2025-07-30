package pagerepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	// 1. WebElement Identification and Declaration

		@FindBy(id = "checkout")
		private WebElement checkoutbtn;
		
		@FindBy(className = "inventory_item_name")
		private List<WebElement> itemNames;

		@FindBy(className = "inventory_item_price")
		private List<WebElement> itemPrices;

		@FindBy(className = "cart_quantity")
		private List<WebElement> itemQuantities;

		// 2 .WebElement Initialization

		public CartPage(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}

		// 3. WebElement Utilization

		public WebElement getcheckoutbtn() {
			return checkoutbtn;
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
