package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//input[@id='input-email']") WebElement LoginEmail;
	@FindBy(xpath = "//input[@id='input-password']") WebElement LoginPassword;
	
	@FindBy(xpath = "//input[@value='Login']") WebElement Login;
	
	public void Enteremail(String email) {
		LoginEmail.sendKeys(email);
	}
	
	public void EnterPswd(String pwd) {
		LoginPassword.sendKeys(pwd);
	}
	
	public void ClickLogin() {
		Login.click();
	}
	
}
