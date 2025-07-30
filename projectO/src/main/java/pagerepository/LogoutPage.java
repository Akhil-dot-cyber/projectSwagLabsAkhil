package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	//identification and declaration
	  @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	  
       private WebElement menu;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutbutton;	
	

	//intialization
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	
	public WebElement getMenu() {
		return menu;
		
	}
	
	public WebElement getlogoutbutton() {
		return logoutbutton;
		
	}
}
