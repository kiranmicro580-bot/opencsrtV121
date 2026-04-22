package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseTest;

public class TC003__LoginDDT extends BaseTest {

	@Test(dataProvider = "LoginData", dataProviderClass = utilities.DataProviders.class)
	public void verifyloginTest(String email, String password, String res) {
		try {
			HomePage hp = new HomePage(driver);
			logger.info("Starting the test TC002__LoginDDT.....");
			hp.clickMyAccount();
			hp.clickLogin();
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			MyAccountPage macc = new MyAccountPage(driver);
			boolean pageStatus = macc.isMyAccountPageExists();

			if (res.equalsIgnoreCase("valid")) {
				if (pageStatus == true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (res.equalsIgnoreCase("invalid")) {
				if (pageStatus == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}

			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("Finsed the test TC002__LoginDDT.....");
	}

}
