package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends BasePage {

	public MyAccountpage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement MyAccountText;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']" ) WebElement Logout;
	
	public boolean isMyAccountPageexists() {
		
		try {
			return(MyAccountText.isDisplayed());
		}
		catch (Exception e){
			return false;
		}
		
		
	}
	
	public void AccountLogout() {
		Logout.click();
	}

}
