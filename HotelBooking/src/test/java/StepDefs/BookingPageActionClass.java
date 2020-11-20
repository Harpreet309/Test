package StepDefs;

import java.io.IOException;

import BasePackage.Screenshot;
import BasePackage.TestBase;
import PageClasses.BookingPageClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BookingPageActionClass extends TestBase{
	
	BookingPageClass Booking;
	
	@When("^User select confirm booking without entering the First Name(.*) then Validates the alert box with message$")
	public void user_select_confirm_booking_without_entering_the_First_Name_then_Validates_the_alert_box_with_message(String First_Name) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Booking = new BookingPageClass();
	    Booking.AssertFirstName(First_Name);
	}

	@When("^User select confirm booking without entering the Last Name(.*) then Validates the alert box with message$")
	public void user_select_confirm_booking_without_entering_the_Last_Name_then_Validates_the_alert_box_with_message(String Last_Name) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Booking.AssertLastName(Last_Name);
	}

	@When("^Validate Email format in alert box by giving invalid email format$")
	public void validate_Email_format_in_alert_box_by_giving_invalid_email_format() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Booking.AssertEmailFormat("Harry@gmail.com");
	    
	}

	@When("^User select confirm booking without entering contact number(.*) then validates the alert box with message$")
	public void user_select_confirm_booking_without_entering_contact_number_then_validates_the_alert_box_with_message(String Contact_Number) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Booking.AssertContactNumber(Contact_Number);
	}

	@When("^Validate whether Correct Format of contact number(.*) is enetered or not$")
	public void validate_whether_Correct_Format_of_contact_number_is_enetered_or_not(String Contact_Number) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Booking.AssertContactNumberFormat(Contact_Number);
	}

	@When("^Validate Rooms and Number of guests(.*)$")
	public void Validate_Rooms_and_Number_of_guests(String Guest_Number) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Booking.AssertRooms_Guests(Guest_Number);
	   }

	@Then("^Enter the Address details and it should not be empty$")
	public void enter_the_Address_details_and_it_should_not_be_empty() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Booking.Address("Ozone Villa");
		
	}

	@Then("^Validate the alert box with message if city(.*) is not selected$")
	public void validate_the_alert_box_with_message_if_city_is_not_selected(String City) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Booking.AssertCity(City);
	}

	@Then("^Validate the alert box with message if state(.*) is not selected$")
	public void validate_the_alert_box_with_message_if_state_is_not_selected(String State) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Booking.AssertState(State);
	}

	@Then("^Enter Card Holder name(.*) and Validate the alert box if Card Holder Name is not entered$")
	public void enter_Card_Holder_name_and_Validate_the_alert_box_if_Card_Holder_Name_is_not_entered(String Name) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Booking.AssertCardHolderName(Name);
	}

	@Then("^Enter Debit Card Number Holder(.*) and Validate the alert box if Card Number is not entered$")
	public void enter_Debit_Card_Number_Holder_and_Validate_the_alert_box_if_Card_Number_is_not_entered(String Card_Number) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Booking.AssertDebitCardNmber(Card_Number);
	}
	
	@Then("^Enter Card Expiration Month(.*) and Validate the alert box if Expiration Month is not entered$")
	public void enter_Card_Expiration_Month_and_Validate_the_alert_box_if_Expiration_Month_is_not_entered(String Exp_Month) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Booking.AssertCardExpMonth(Exp_Month);
	}
	
	@Then("^Enter CVV Number(.*) and Validate the alert box if CVV is not entered$")
	public void Enter_CVV_Number_and_Validate_the_alert_box_if_CVV_is_not_entered(String CVV) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Booking.AssertCVV(CVV);
	}

	@Then("^Enter Card Expiration Year(.*) and Validate the alert box if Expiration Year is not entered$")
	public void enter_Card_Expiration_Year_and_Validate_the_alert_box_if_Expiration_Year_is_not_entered(String Exp_Year) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Booking.AssertCardExpYear(Exp_Year);
	}

	@Then("^Click on confirm booking after filling the form$")
	public void click_on_confirm_booking_after_filling_the_form() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Booking.Confirm_BTN();
	   
	}
	
	@SuppressWarnings("deprecation")
	@And("^Validate Booking confirmed message$")
	public void Booking_Confirmed() throws IOException
	{
		Assert.assertEquals("Booking Completed!", Booking.BookingComplete());
		Screenshot.getscreenshot(driver);
		shutdown();
	}

}
