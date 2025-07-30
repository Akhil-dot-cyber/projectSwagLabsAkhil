package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

	// 1. WebElement Identification and Declaration

		@FindBy(id = "back-to-products")
		private WebElement back2prod;
		
		
		// 2 .WebElement Initialization

		public CheckoutCompletePage(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}

		// 3. WebElement Utilization

		public WebElement getback2prod() {
			return back2prod;
		}
}




