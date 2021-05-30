 package PageClasses;

import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.Screenshot;
import BasePackage.TestBase;
import junit.framework.Assert;

public class BookingPageClass extends TestBase {
	
	 private Pattern regexPattern;
	 private Matcher regMatcher;
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	@FindBy(id="txtFirstName")
	WebElement FirstName;
	
	@FindBy(id="txtLastName")
	WebElement LastName;
	
	@FindBy(id="txtEmail")
	WebElement Email;
	
	@FindBy(id="txtPhone")
	WebElement ContactNumber;
	
	@FindBy(xpath="//td//textarea")
	WebElement Address;
	
	@FindBy(name="city")
	WebElement SelectCity;
	
	@FindBy(name="state")
	WebElement SelectState;
	
	@FindBy(name="persons")
	WebElement Guests;
	
	@FindBy(id="rooms")
	WebElement Rooms;
	
	@FindBy(id="txtCardholderName")
	WebElement CardHolderName;
	
	@FindBy(id="txtDebit")
	WebElement DebitCardNumber;
	
	@FindBy(id="txtCvv")
	WebElement CVV;
	
	@FindBy(id="txtMonth")
	WebElement Exp_Month;
	
	@FindBy(id="txtYear")
	WebElement Exp_Year;
	
	@FindBy(id="btnPayment")
	WebElement ConfirmBooking;
	
	@FindBy(xpath="//h1[contains(text(),'Booking Completed!')]")
	WebElement BookingCompleteMessage;
	
	public BookingPageClass()
	{
		PageFactory.initElements(driver, this);
	}
	
	@SuppressWarnings("deprecation")
	public void AssertFirstName(String First) throws InterruptedException, IOException
	{	
		if(First.isEmpty())
		{
			System.out.println("Inside First Name");
			ConfirmBooking.click();
			try {
			wait.until(ExpectedConditions.alertIsPresent());
			}
			catch(Exception e)
			{
				System.out.println("No Alert Present");
			}
			
			String Alert_Text = driver.switchTo().alert().getText();
			
			Assert.assertEquals("Please fill the First Name", Alert_Text);
			
			Screenshot.getscreenshot(driver);
			
			driver.switchTo().alert().accept();
			
			System.out.println("First Name Alert got verified with message");
			
			Assert.fail();
		}
		else
		{
			FirstName.sendKeys(First);
			Thread.sleep(1000);
			System.out.println("First Name Value entered");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public void AssertLastName(String Last) throws InterruptedException, IOException
	{

		if(Last.isEmpty())
		{
			ConfirmBooking.click();
			try {
			wait.until(ExpectedConditions.alertIsPresent());
			}
			catch(Exception e)
			{
				System.out.println("No Alert Present");
			}
			
			String Alert_Text = driver.switchTo().alert().getText();
			
			Assert.assertEquals("Please fill the Last Name", Alert_Text);
			
			Screenshot.getscreenshot(driver);
			
			driver.switchTo().alert().accept();
			
			System.out.println("Last Name Alert got verified with message");
			
			Assert.fail("Last Name must not be empty");
		}
		else
		{
			LastName.sendKeys(Last);
			Thread.sleep(1000);
			System.out.println("Last Name Value entered");
		}
		
	
	}
	
	@SuppressWarnings("deprecation")
	public void AssertEmailFormat(String emailAddress) throws InterruptedException, IOException
	{
		 regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
	        regMatcher = regexPattern.matcher(emailAddress);
	        if(regMatcher.matches()) {
	        	Email.clear();
	        	Email.sendKeys(emailAddress);
	        	Thread.sleep(1000);
	        	System.out.println("Valid Email ID is entered");
	        } else {
	        	Email.sendKeys(emailAddress);
	        	ConfirmBooking.click();
	        	try {
	    			wait.until(ExpectedConditions.alertIsPresent());
	    			}
	    			catch(Exception e)
	    			{
	    				System.out.println("No Alert Present");
	    			}
	        String Alert_Text =	driver.switchTo().alert().getText();
	        Assert.assertEquals("Please enter valid Email Id.", Alert_Text);
	        Screenshot.getscreenshot(driver);
	        driver.switchTo().alert().accept();
	        System.out.println("Invalid Email is entered. Please enter in correct format");
	        Assert.fail();
	        }
	    }
	
	@SuppressWarnings("deprecation")
	public void AssertContactNumber(String Contact) throws IOException
	{
		if(Contact.isEmpty())
		{
		ConfirmBooking.click();
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			}
			catch(Exception e)
			{
				System.out.println("No Alert Present");
			}
		    String Alert_Text =	driver.switchTo().alert().getText();
	        Assert.assertEquals("Please fill the Mobile No.", Alert_Text);	
	        
	        Screenshot.getscreenshot(driver);
	        
	        driver.switchTo().alert().accept();
	        
	        System.out.println("Contact Number alert got displayed and accepted successfully");
	        
	        System.out.println("Please Enter Contact Number before proceeding");
	        
	        Assert.fail("Contact Number must not be empty. Please fill Contact Number");
		}
		else
		{
			System.out.println("Contact Number is Present. Please proceed to next field");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void AssertContactNumberFormat(String Contact) throws InterruptedException, IOException
	{
		String regex = "[789][0-9]{9}";
		if(Contact.matches(regex))
		{
			ContactNumber.clear();
			ContactNumber.sendKeys(Contact);
			Thread.sleep(1000);
			System.out.println("Contact number format is validated: " + "" + Contact);
		}
		else
		{
		ContactNumber.sendKeys(Contact);
    	ConfirmBooking.click();
    	try {
			wait.until(ExpectedConditions.alertIsPresent());
			}
			catch(Exception e)
			{
				System.out.println("No Alert Present");
			}
    String Alert_Text =	driver.switchTo().alert().getText();
    Assert.assertEquals("Please enter valid Contact no.", Alert_Text);	
    Screenshot.getscreenshot(driver);
    driver.switchTo().alert().accept();
    System.out.println("Invalid Contact number is entered. Please enter in correct format");
    Assert.fail();
	}
	}
	
	public void Address(String AddressDetails) throws InterruptedException
	{
		Address.clear();
		Address.sendKeys(AddressDetails);
		Thread.sleep(1000);
	}
	
	@SuppressWarnings("deprecation")
	public void AssertCity(String City) throws IOException
	{
		if(City.isEmpty())
		{
			ConfirmBooking.click();
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				}
				catch(Exception e)
				{
					System.out.println("No Alert Present");
				}
			    String Alert_Text =	driver.switchTo().alert().getText();
		        Assert.assertEquals("Please select city", Alert_Text);
		        Screenshot.getscreenshot(driver);
		        driver.switchTo().alert().accept();
		        System.out.println("City alert got displayed and accepted successfully");
		        Assert.fail("Please Select City before Proceeding");
		}
		else
		{
			Select select = new Select(SelectCity);
			try
			{
				select.selectByValue(City);
				Thread.sleep(1000);
				System.out.println("City Selected Successfully");
			}
			catch(Exception e)
			{
				System.out.println("No Such City Present. Please Select Correct City");
			}
		}
		}
	
	@SuppressWarnings("deprecation")
	public void AssertState(String State) throws IOException
	{
		if(State.isEmpty())
		{
			ConfirmBooking.click();
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				}
				catch(Exception e)
				{
					System.out.println("No Alert Present");
				}
			    String Alert_Text =	driver.switchTo().alert().getText();
		        Assert.assertEquals("Please select state", Alert_Text);	
		        Screenshot.getscreenshot(driver);
		        driver.switchTo().alert().accept();
		        System.out.println("State alert got displayed and accepted successfully");
		        Assert.fail("Please Select State before Proceeding");
		}
		else
		{
			Select select = new Select(SelectState);
			try
			{
				select.selectByValue(State);
				Thread.sleep(1000);
				System.out.println("State Selected Successfully");
			}
			catch(Exception e)
			{
				System.out.println("No Such State Present. Please Select Correct State");
			}
		}
		}
	
	@SuppressWarnings("deprecation")
	public void AssertRooms_Guests(String Persons)
	{
		Select select = new Select(Guests);
		select.selectByValue(Persons);
		int guest = Integer.parseInt(Persons);
		if(guest <= 3)
		{
			Assert.assertEquals("1", Rooms.getText());
			System.out.println("Number of Rooms selected: "+""+ Rooms.getText());
		}
		else if((guest>3) && (guest<=6))
		{
			Assert.assertEquals("2", Rooms.getText());
			System.out.println("Number of Rooms selected: "+""+ Rooms.getText());
		}
		else if(guest>6)
		{
			Assert.assertEquals("3", Rooms.getText());
			System.out.println("Number of Rooms selected: "+""+ Rooms.getText());
		}
	}
	
	@SuppressWarnings("deprecation")
	public void AssertCardHolderName(String Card_Name) throws InterruptedException, IOException
	{
		if(Card_Name.isEmpty())
		{
			ConfirmBooking.click();
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				}
				catch(Exception e)
				{
					System.out.println("No Alert Present");
				}
			    String Alert_Text =	driver.switchTo().alert().getText();
		        Assert.assertEquals("Please fill the Card holder name", Alert_Text);	
		        Screenshot.getscreenshot(driver);
		        driver.switchTo().alert().accept();
		        System.out.println("Card Holder Name alert got displayed and accepted successfully");
		        Assert.fail("Please enter Card Holder Name before Proceeding");
		}
		else
		{
			CardHolderName.sendKeys(Card_Name);
			Thread.sleep(1000);
			System.out.println("Card Holder Name is entered");
		
		}
	}
	
	@SuppressWarnings("deprecation")
	public void AssertDebitCardNmber(String Debit_Number) throws InterruptedException, IOException
	{
		if(Debit_Number.isEmpty())
		{
			ConfirmBooking.click();
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				}
				catch(Exception e)
				{
					System.out.println("No Alert Present");
				}
			    String Alert_Text =	driver.switchTo().alert().getText();
		        Assert.assertEquals("Please fill the Debit card Number", Alert_Text);	
		        Screenshot.getscreenshot(driver);
		        driver.switchTo().alert().accept();
		        System.out.println("Debit Card Number alert got displayed and accepted successfully");
		        Assert.fail("Please enter Debit Card Number before Proceeding");
		}
		else
		{
			DebitCardNumber.sendKeys(Debit_Number);
			Thread.sleep(1000);
			System.out.println("Debit Card Number is entered");
		}
	}
	@SuppressWarnings("deprecation")
	public void AssertCardExpMonth(String Expiry_Month) throws InterruptedException, IOException
	{
		if(Expiry_Month.isEmpty())
		{
			ConfirmBooking.click();
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				}
				catch(Exception e)
				{
					System.out.println("No Alert Present");
				}
			    String Alert_Text =	driver.switchTo().alert().getText();
		        Assert.assertEquals("Please fill expiration month", Alert_Text);	
		        Screenshot.getscreenshot(driver);
		        driver.switchTo().alert().accept();
		        System.out.println("Expiry Month alert got displayed and accepted successfully");
		        Assert.fail("Please enter Debit Card Expiry month before Proceeding");
		}
		else
		{
			Exp_Month.sendKeys(Expiry_Month);
			Thread.sleep(1000);
			System.out.println("Debit Expiry Month is entered");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void AssertCardExpYear(String Expiry_Year) throws InterruptedException, IOException
	{
		if(Expiry_Year.isEmpty())
		{
			ConfirmBooking.click();
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				}
				catch(Exception e)
				{
					System.out.println("No Alert Present");
				}
			    String Alert_Text =	driver.switchTo().alert().getText();
		        Assert.assertEquals("Please fill the expiration year", Alert_Text);	
		        Screenshot.getscreenshot(driver);
		        driver.switchTo().alert().accept();
		        System.out.println("Expiry Year alert got displayed and accepted successfully");
		        Assert.fail("Please enter Debit Card Expiry year before Proceeding");
		}
		else
		{
			Exp_Year.sendKeys(Expiry_Year);
			Thread.sleep(1000);
			System.out.println("Debit Expiry Year is entered");
			
		}
	}
	@SuppressWarnings("deprecation")
	public void AssertCVV(String cvv) throws InterruptedException, IOException
	{
		if(cvv.isEmpty())
		{
			ConfirmBooking.click();
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				}
				catch(Exception e)
				{
					System.out.println("No Alert Present");
				}
			    String Alert_Text =	driver.switchTo().alert().getText();
		        Assert.assertEquals("Please fill the CVV", Alert_Text);	
		        Screenshot.getscreenshot(driver);
		        driver.switchTo().alert().accept();
		        System.out.println("CVV alert got displayed and accepted successfully");
		        Assert.fail("Please enter CVV before Proceeding");
		}
		else
		{
			CVV.sendKeys(cvv);
			Thread.sleep(1000);
			System.out.println("CVV Number is entered");
			
		}
	}
	public void Confirm_BTN() throws InterruptedException, IOException
	{
		Screenshot.getscreenshot(driver);
		ConfirmBooking.click();
		Thread.sleep(1000);
		System.out.println("All Fields are verified and filled. Booking Confirmed!!!");
	}
	
	public String BookingComplete()
	{
		//Assert.assertEquals("Booking Completed!!!", BookingCompleteMessage.getText());
		String Text = BookingCompleteMessage.getText();
		return Text;
		
	}
	
	}
	

