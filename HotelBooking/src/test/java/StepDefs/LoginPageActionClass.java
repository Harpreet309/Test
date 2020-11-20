package StepDefs;

import org.openqa.selenium.By;

import BasePackage.Screenshot;
import BasePackage.TestBase;
import PageClasses.LoginPageClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginPageActionClass extends TestBase {

	LoginPageClass Login;
	

	
	@Given("^User is on login page and verify page heading$")
	public void user_is_on_login_page_and_verify_page_heading() throws Throwable {	
		initialization();
		Login = new LoginPageClass();
		Login.LoginPageHeading();
	   
	}
	
	@Given("^Validate Error messages by clicking on Login Button if Username and Password is not given$")
	public void validate_Error_messages_by_clicking_on_Login_Button_Without_Entering_Username_and_Password() throws Throwable {
		Login = new LoginPageClass();
		Login.AssertErrorMessages(prop.getProperty("Username"),prop.getProperty("Password"));
	    
	}

	@SuppressWarnings("deprecation")
	@Then("^User should navigate to Hotel Booking Page and Validates Page Title$")
	public void user_should_navigate_to_Hotel_Booking_Page_and_Validates_Page_Title() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Login = new LoginPageClass();
		Assert.assertEquals("Hotel Booking", Login.BookingPageTitle());
		Screenshot.getscreenshot(driver);
	}

}
