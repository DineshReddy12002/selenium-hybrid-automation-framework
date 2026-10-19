package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	

	@FindBy(xpath = "//input[@id='input-firstname']") WebElement frtsnm;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement lstnm;
	@FindBy(xpath = "//input[@id='input-email']") WebElement txtemail;
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement phno; 
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtpwd;
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement txtcnfmpwd;
	@FindBy(xpath = "//input[@name='agree']") WebElement chkbx;
	@FindBy(xpath = "//input[@value='Continue']") WebElement submitbtn;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmMSG; 
	
	public void FirstName(String fname) {
		frtsnm.sendKeys(fname);
	}
	
	public void LastName(String lname) {
		lstnm.sendKeys(lname);
	}
	
	public void SetEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void SetTelephone(String tel) {
		phno.sendKeys(tel);
	}
	
	public void SetPassword(String pwd) {
		txtpwd.sendKeys(pwd);
	}
	
	public void ReEnterPassword(String pwd) {
		txtcnfmpwd.sendKeys(pwd);
	}
	
	public void CheckBox() {
		chkbx.click();
	}
	
	public void SubmitButton() {
		submitbtn.click();
	}
	
	public String  SuccessfulMSG() {
		return confirmMSG.getText();
	}
	

}
