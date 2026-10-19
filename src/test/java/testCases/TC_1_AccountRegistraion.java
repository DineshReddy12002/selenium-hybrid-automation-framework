package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_1_AccountRegistraion extends BaseClass {
	

	@Test(groups={"Sanity" , "Master"})
	void test() {
		
		logger.info("* Starting Test *");
		
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("* Clicking My Account *");
		hp.ClickRegister();
		logger.info("* Clicking on Register *");
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		logger.info("* Customer Details *");
		arp.FirstName(randomString().toUpperCase());
		arp.LastName(randomString().toUpperCase());
		arp.SetEmail(randomString()+"@gmail.com");
		arp.SetTelephone(randomNumber());
		String password = randomAlphaNumeric();
		arp.SetPassword(password);
		arp.ReEnterPassword(password);
		arp.CheckBox();
		arp.SubmitButton();
		try {
		String actualmessage = arp.SuccessfulMSG();
		Assert.assertEquals(actualmessage, "Your Account Has Been Created!");
		
		logger.info(" * Finished Test * ");
		
	}
	catch (AssertionError e) {
        logger.error("❌ TEST FAILED - Expected message not found: " + e.getMessage());
        throw e;
    }
	}
	
}
