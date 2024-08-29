package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Search {
	
	WebDriver driver;
	 @Given("User opens the Application")
	    public void user_opens_the_application() {
		 driver = DriverFactory.getDriver();
	    }

	    @When("User enters valid product {string} into Search box field")
	    public void user_enters_valid_product_into_search_box_field(String validproduct) {
	    	driver.findElement(By.name("search")).sendKeys(validproduct);
	    }

	    @When("User enters invalid product {string} into Search box field")
	    public void user_enters_invalid_product_into_search_box_field(String invalidproduct) {
	    	driver.findElement(By.name("search")).sendKeys(invalidproduct);
	    }

	    @When("User does not enter any product name into Search box field")
	    public void user_does_not_enter_any_product_name_into_search_box_field() {
	    	//Intentionally kept blank
	    }

	    @And("User clicks on Search button")
	    public void user_clicks_on_search_button() {
	    	driver.findElement(By.xpath("//button[contains(@class,'btn-default btn-lg')]")).click();
	    }

	    @Then("User should get valid product displayed in search results")
	    public void user_should_get_valid_product_displayed_in_search_results() {
	    	Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	    }

	    @Then("User should get a message about no product matching")
	    public void user_should_get_a_message_about_no_product_matching() {
	    	Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
	    	
	    }

}
