package PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.TestBase;

public class CRMLoginPageClass extends TestBase{

	@FindBy(xpath="//input[@name='email']")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	public WebElement login_button;
	
	public CRMLoginPageClass()
	{
		PageFactory.initElements(driver, this);
	}
	
}
