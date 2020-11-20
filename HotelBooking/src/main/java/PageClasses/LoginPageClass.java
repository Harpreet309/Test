package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.Screenshot;
import BasePackage.TestBase;
import junit.framework.Assert;

public class LoginPageClass extends TestBase {
	Screenshot sc = new Screenshot();
	
	@FindBy(xpath="//h1[contains(text(),'Hotel Booking Application')]")
	WebElement LoginHeading;
	
	@FindBy(xpath="//h2[contains(text(),'Hotel Booking Form')]")
	WebElement BookingPageTitle;
	
	@FindBy(name="userName")
	WebElement UserName;
	
	@FindBy(name="userPwd")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginBtn;
	
	@FindBy(id="userErrMsg")
	WebElement UserNameErrorMsg;
	
	@FindBy(id="pwdErrMsg")
	WebElement PasswordErrorMsg;
	
	
	public LoginPageClass()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void LoginPageHeading() throws InterruptedException
	{
		
		try {
		Assert.assertEquals("Hotel Booking Application", LoginHeading.getText());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
			
	}
	
	@SuppressWarnings("deprecation")
	public void AssertErrorMessages(String Uname , String PWD) throws IOException
	{
		if(Uname.isEmpty())
		{
			LoginBtn.click();
			Assert.assertTrue(UserNameErrorMsg.isDisplayed());
			Screenshot.getscreenshot(driver);
			Assert.fail("Please enter Username to proceed");
		}else
		{
			UserName.sendKeys(Uname);
		}
		if(PWD.isEmpty())
		{
			LoginBtn.click();
			Assert.assertTrue(PasswordErrorMsg.isDisplayed());
			Screenshot.getscreenshot(driver);
			Assert.fail("Please enter password to proceed");
		}
		else
		{
			Password.sendKeys(PWD);
			Screenshot.getscreenshot(driver);
			LoginBtn.click();		
			
		}
			
	}
	/*
	 * public void UserCredentials(String Uname , String PWD) throws IOException {
	 * UserName.clear(); Password.clear(); UserName.sendKeys(Uname);
	 * Password.sendKeys(PWD); Screenshot.getscreenshot(driver); LoginBtn.click();
	 * 
	 * }
	 */
	
	public String BookingPageTitle()
	{
		return driver.getTitle();
	}
	

}
