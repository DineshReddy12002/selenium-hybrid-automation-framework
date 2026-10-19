package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement clkAccount;
	@FindBy(xpath = "//a[normalize-space()='Register']") WebElement clkRegister;
	@FindBy(xpath = "//a[normalize-space()='Login']") WebElement clkLogin;
	
	public void ClickMyAccount() {
		clkAccount.click();
	}
	
	public void ClickRegister() {
		clkRegister.click();
	}
	
	public void ClickLogin() {
		clkLogin.click();
	}
}











