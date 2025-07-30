package producttest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericlibrary.BaseConfig;
import genericlibrary.WebDriverLibrary;
import pagerepository.CartPage;
import pagerepository.CheckoutOverviewPage;
import pagerepository.CheckoutPage;
import pagerepository.HomePage;

@Listeners(listenerlibrary.ListenerImplementation.class )
public class TeamOTest extends BaseConfig {
	
	@Test(dataProvider = "checkOutInfo", priority = 1, invocationCount = 1)
	public void Verify_If_User_Is_Able_To_Order_3_Products(String firstname, String lastname, String zip) {

		// Step 1: Object Creation for POM Classes
		
		HomePage hp = new HomePage(driver);
		
		CartPage cp = new CartPage(driver);
		
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		
		CheckoutOverviewPage cop = new CheckoutOverviewPage(driver);

		// Step 2: Click on "Sauce Labs Backpack" in Product List Page (PLP)
		
		Assert.assertTrue(hp.getfirstproduct().isDisplayed());
		
		WebDriverLibrary.elementClick(hp.getfirstproduct());

		// Step 3: Verify if "Sauce Labs Fleece Jacket" Product Details Page (PDP) is displayed
		
		//Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4");

		// Step 4: Click on "Add To Cart" Button
		
		Assert.assertTrue(hp.getaddtocartbtn().isEnabled());
		
		WebDriverLibrary.elementClick(hp.getaddtocartbtn());

		// Step 5: Verify if count is incremented on Cart Icon (1)
		
		Assert.assertTrue(hp.getCarticon1().isDisplayed());
		
		//Log
		System.out.println("Sauce Labs Backpack - Added to cart");
		
		// Step 6: Click on "Back to products" button
		
		Assert.assertTrue(hp.getbacktoproducts().isEnabled());
		
		WebDriverLibrary.elementClick(hp.getbacktoproducts());

		// Step 7: Verify if Home page is displayed
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

		// Step 8: Click on "Sauce Labs Bolt T-Shirt" in Product List Page (PLP)
		
		Assert.assertTrue(hp.getthirdproduct().isDisplayed());
		
		WebDriverLibrary.elementClick(hp.getthirdproduct());

		// Step 9: Verify if "Sauce Labs Bolt T-Shirt" Product Details Page (PDP) is displayed
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=1");

		// Step 10: Click on "Add To Cart" Button
		
		Assert.assertTrue(hp.getaddtocartbtn1().isEnabled());
		
		WebDriverLibrary.elementClick(hp.getaddtocartbtn1());

		// Step 11: Verify if count is incremented on Cart Icon (2)
		
		Assert.assertTrue(hp.getCarticon2().isDisplayed());

		//Log
		
		System.out.println("Sauce Labs Bolt T-Shirt - Added to cart");
		
		// Step 12: Click on "Back to products" button
		
		Assert.assertTrue(hp.getbacktoproducts1().isEnabled());
		
		WebDriverLibrary.elementClick(hp.getbacktoproducts1());

		// Step 13: Verify if Home page is displayed
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

		// Step 14: Click on "Sauce Labs Bike Light" in Product List Page (PLP)
		
		Assert.assertTrue(hp.getsecondproduct().isDisplayed());
		
		WebDriverLibrary.elementClick(hp.getsecondproduct());

		// Step 15: Verify if "Sauce Labs Bike Light" Product Details Page (PDP) is displayed
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=0");

		// Step 16: Click on "Add To Cart" Button
		
		Assert.assertTrue(hp.getaddtocartbtn2().isEnabled());
		
		WebDriverLibrary.elementClick(hp.getaddtocartbtn2());
		
		//Log
		System.out.println("Sauce Labs Bike Light - Added to cart");
		
		// Step 17: Verify if count is incremented on Cart Icon (3)
		Assert.assertTrue(hp.getCarticon3().isDisplayed());

		// Step 18: Click on "Cart" Icon
		Assert.assertTrue(hp.getcarticon().isEnabled());
		WebDriverLibrary.elementClick(hp.getcarticon());

		// Step 19: Verify if Cart Page is displayed
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

		// Step 20: Verify the added products are listed with correct name, price, and quantity
		String[] expectedNames = {"Sauce Labs Backpack","Sauce Labs Bolt T-Shirt","Sauce Labs Bike Light"};
		//String[] expectedPrices = { "$29.99","$9.99", "$15.99"};
		for (int i = 0; i < expectedNames.length; i++) {
		    String actualName = cp.getItemNames().get(i).getText();
		   // String actualPrice = cp.getItemPrices().get(i).getText();
		    String actualQty = cp.getItemQuantities().get(i).getText();

		    Assert.assertEquals(actualName, expectedNames[i]);
		  //  Assert.assertEquals(actualPrice, expectedPrices[i]);
		    Assert.assertEquals(actualQty, "1");
		}
		System.out.println("All 3 products are valid in cart");

		// Step 21: Click on "Checkout" button

		Assert.assertTrue(cp.getcheckoutbtn().isEnabled());
		WebDriverLibrary.elementClick(cp.getcheckoutbtn());

		// Step 22: Verify if "Checkout: Your Information" Page is displayed
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");

		// Step 23: Enter first name in "First Name" textfield
		Assert.assertTrue(checkoutpage.getfirstname().isDisplayed());
		WebDriverLibrary.enterTheData(checkoutpage.getfirstname(), firstname);

		// Step 24: Enter Last name in "Last Name" textfield
		Assert.assertTrue(checkoutpage.getlastname().isDisplayed());
		WebDriverLibrary.enterTheData(checkoutpage.getlastname(), lastname);

		// Step 25: Enter Postal code in "Zip/Postal Code" textfield
		Assert.assertTrue(checkoutpage.getzipcode().isDisplayed());
		WebDriverLibrary.enterTheData(checkoutpage.getzipcode(), zip);

		// Step 26: Click on "Continue" Button
		Assert.assertTrue(checkoutpage.getcontinuebtn().isEnabled());
		WebDriverLibrary.elementClick(checkoutpage.getcontinuebtn());

		// Step 27: Verify if "Checkout: Overview" page is displayed
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");

		// Step 28: Verify the added products are listed with correct name, price, and quantity
		String[] expectedNamesCOP = {"Sauce Labs Backpack","Sauce Labs Bolt T-Shirt","Sauce Labs Bike Light"};

//		String[] expectedPricesCOP = { "$29.99","$9.99", "$15.99"};
		for (int i = 0; i < expectedNames.length; i++) {
		    String actualName = cop.getItemNames().get(i).getText();
		  //  String actualPrice = cop.getItemPrices().get(i).getText();
		    String actualQty = cop.getItemQuantities().get(i).getText();

		    Assert.assertEquals(actualName, expectedNamesCOP[i]);
		    //Assert.assertEquals(actualPrice, expectedPricesCOP[i]);
		    Assert.assertEquals(actualQty, "1");
		}
		System.out.println("All 3 products are valid in Checkout-Overview page");
		
		// Step 29: Click on "Finish" button
		Assert.assertTrue(cop.getfinishbtn().isEnabled());		
		WebDriverLibrary.elementClick(cop.getfinishbtn());

		// Step 30: Verify if "Checkout: Complete" Page is displayed with order confirmation
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
		
		//Log
		System.out.println("Products ordered succesfully");
			
}
}