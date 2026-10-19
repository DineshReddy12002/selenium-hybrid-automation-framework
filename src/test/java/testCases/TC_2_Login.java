package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import testBase.BaseClass;

public class TC_2_Login extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void test() {
		try {
			HomePage hp = new HomePage(driver);

			logger.info("* Starting Login *");

			hp.ClickMyAccount();
			hp.ClickLogin();

			logger.info("* Clicked Login *");

			LoginPage lp = new LoginPage(driver);
			lp.Enteremail(p.getProperty("email"));
			lp.EnterPswd(p.getProperty("password"));
			lp.ClickLogin();

			MyAccountpage map = new MyAccountpage(driver);
			boolean targetpage = map.isMyAccountPageexists();
			Assert.assertTrue(targetpage);
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("* Finished Login Test *");

	}

}
