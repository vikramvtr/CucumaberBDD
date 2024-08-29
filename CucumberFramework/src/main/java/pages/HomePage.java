package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropDown;	
	public void myAccountDropDown()
	{
		myAccountDropDown.click();
	}	
	public WebElement getMyAccountDropDown() {
		return myAccountDropDown;
	}
	

	@FindBy(linkText = "Login")
	private WebElement loginOption;
	public void loginOption()
	{
		loginOption.click();
	}
	public WebElement getLoginOption() {
		return loginOption;
	}


}
