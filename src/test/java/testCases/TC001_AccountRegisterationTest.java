package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.HomePage;
import pageObject.RegisterPage;
import testBase.BaseTest;

public class TC001_AccountRegisterationTest extends BaseTest {

	@Test(groups={"regression","master"})
	public void verify_account_registeration() {
		try {
			logger.info("Starting the test...........");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on my account.....");
			hp.clickRegister();

			RegisterPage rp = new RegisterPage(driver);
			logger.info("providing customer details.....");
			rp.setFirstName(randomString().toUpperCase());
			rp.setLastName(randomString().toUpperCase());
			rp.setEmail(randomString().toUpperCase() + "@gmail.com");
			rp.setTelePhone(randomNumber());
			String pass = randomAlphaNumeric();
			rp.setPassword(pass);
			rp.setCoinfirmPassword(pass);
			rp.setPrivacyPolicy();
			rp.clickContinue();

			logger.info("Checking expected message.......");
			String message = rp.verifyMessage();
//		Assert.assertEquals(message, "Your Account Has Been Created!");
			if (message.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {

				logger.error("Test Failed");
				logger.debug("debug logs");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("Test finished.....");
	}

}
