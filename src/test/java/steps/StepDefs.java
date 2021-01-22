package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import junit.framework.Assert;
import page.LoginPage;
import util.BrowserFactory;

public class StepDefs {
	WebDriver driver;
	LoginPage login;
	@Before
	public void beforeRun() {
		driver = BrowserFactory.init();
		login = PageFactory.initElements(driver, LoginPage.class);
		
		
		
		
	}
	
	@Given("^User is on the TechFios Login Page$")
	public void user_is_on_the_TechFios_Login_Page() throws Throwable {
		driver.get("https://www.techfios.com/billing/?ng=admin/");  
	}

	@When("^User enters the username as \"([^\"]*)\"$")
	public void user_enters_the_username_as(String username) throws Throwable {
	    login.enterUsername(username);
	    Thread.sleep(2000);
	}

	@When("^User enters the password as \"([^\"]*)\"$")
	public void user_enters_the_password_as(String password) throws Throwable {
	    login.enterPassword(password);
	    Thread.sleep(2000);
	}
	
	@And("^User clicks on the log in button$")
	public void user_clicks_on_the_log_in_button() throws Throwable {
		login.clickSignnigbutton();
		Thread.sleep(2000);
	}	
	@When("^User enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_and(String username, String password) throws Throwable {
		login.enterCredentials(username, password);
	}	
		
		
	//@When("^User clicks on the log in button$")
	//public void user_clicks_on_the_log_in_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  //}
	

	@Then("^User should be able to see the DashBoard Page$")
	public void user_should_be_able_to_see_the_DashBoard_Page() throws Throwable {
		//login.getPageTitle();
			String expectedTitle = "Dashboard- iBilling";
			String actualTitle = login.getPageTitle();
			//Assert.assertEquals(expectedTitle, actualTitle);
			Assert.assertEquals(expectedTitle, actualTitle);
			login.takeScreenshotAtEndOfTest(driver);
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
