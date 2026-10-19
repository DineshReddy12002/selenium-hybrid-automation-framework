package testCases;

import org.testng.Assert;
import utilities.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import testBase.BaseClass;

public class TC_3_DataDrivenTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProvider.class , groups="dataDriven" )
	public void verifyTest(String email, String password, String exp) {
		HomePage hp = new HomePage(driver);

		logger.info("* Starting DataDriven Test *");

		hp.ClickMyAccount();
		hp.ClickLogin();

		logger.info("* Clicked Login *");

		LoginPage lp = new LoginPage(driver);
		lp.Enteremail(email);
		lp.EnterPswd(password);
		lp.ClickLogin();

		MyAccountpage map = new MyAccountpage(driver);
		boolean targetpage = map.isMyAccountPageexists();

		if (exp.equalsIgnoreCase("Valid")) {
			// Expect login to succeed
			Assert.assertTrue(targetpage, "Expected login to succeed for valid credentials, but it failed.");
			map.AccountLogout();

		} else if (exp.equalsIgnoreCase("InValid")) {
			// Expect login to fail
			if (targetpage) {
				map.AccountLogout(); // safety cleanup if it unexpectedly logged in
			}
			Assert.assertFalse(targetpage, "Expected login to fail for invalid credentials, but it succeeded.");
		}

		logger.info("* Completed DataDriven Test *");
	}

}