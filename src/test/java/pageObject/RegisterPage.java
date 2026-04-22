package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPasswor;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkBoxPrivacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String firstName) {
		txtFirstname.sendKeys(firstName);

	}

	public void setLastName(String LaststName) {
		txtLastname.sendKeys(LaststName);

	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);

	}

	public void setTelePhone(String telephone) {
		txtTelephone.sendKeys(telephone);

	}

	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);

	}

	public void setCoinfirmPassword(String pass) {
		txtConfirmPasswor.sendKeys(pass);

	}

	public void setPrivacyPolicy() {
		checkBoxPrivacyPolicy.click();

	}

	public void clickContinue() {
		btnContinue.click();

	}

	public String verifyMessage() {
		try {

			return msgConfirmation.getAccessibleName();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
