package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseTest;

public class TC002__LoginTest extends BaseTest {

	@Test(groups= {"sanity","master"})
	public void verifyloginTest() {
		try {
			HomePage hp = new HomePage(driver);
			logger.info("Starting the test TC002__LoginTest.....");
			hp.clickMyAccount();
			hp.clickLogin();
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			MyAccountPage macc = new MyAccountPage(driver);
			boolean pageStatus = macc.isMyAccountPageExists();

			Assert.assertTrue(pageStatus);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("Finsed the test TC002__LoginTest.....");
	}

}
