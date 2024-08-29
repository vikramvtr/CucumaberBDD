package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

import org.junit.Assert;

public class Login {

	WebDriver driver;
	private LoginPage loginpage;

	@Given("User has navigated to login page")
	public void user_has_navigated_to_login_page() {
		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.getMyAccountDropDown();
		homepage.getLoginOption();
	//	driver.findElement(By.linkText("Login")).click();
	}

	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
		loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(emailText);
		//driver.findElement(By.id("input-email")).sendKeys(validemailText);
	}

	@When("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String PasswordText) {
		loginpage.enterPassword(PasswordText);
		//driver.findElement(By.id("input-password")).sendKeys(PasswordText);
	}
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.clickOnLoginButton();
		//driver.findElement(By.xpath("//input[@type='submit']")).submit();
	}

	@Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
		AccountPage accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.displayStatusOfYourAccountInformation());	
    	//Assert.assertEquals("Edit your account information", driver.findElement(By.linkText("Edit your account information")).getText());
    }

	@When("User enters invalid email address {string} into email field")
	public void user_enters_invalid_email_address_into_email_field(String invalidemail) {
		loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(invalidemail);
		driver.findElement(By.id("input-email")).sendKeys(invalidemail);
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidpassword) {
		loginpage.enterPassword(invalidpassword);
		driver.findElement(By.id("input-password")).sendKeys(invalidpassword);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	Assert.assertTrue(loginpage.getWarningMessagetext().contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@When("User does not enter email address into email field")
	public void user_does_not_enter_email_address_into_email_field() {
		loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress("");
		//driver.findElement(By.id("input-email")).sendKeys("");
	}

	@When("User does not enter password into password field")
	public void user_does_not_enter_password_into_password_field() {
		loginpage.enterPassword("");
		//driver.findElement(By.id("input-password")).sendKeys("");
	}
	
//	private String getEmailTimeStamp()
//    {
//    	Date date = new Date();
//    	return "amotoori"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
//    }

}
