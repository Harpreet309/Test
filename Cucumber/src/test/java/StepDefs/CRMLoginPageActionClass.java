package StepDefs;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import BasePackage.TestBase;
import PageClasses.CRMLoginPageClass;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

public class CRMLoginPageActionClass extends TestBase {
	
	public WebDriver driver = TestBase.driver;
	@Given("^User Navigate to the URL and Login to the Application$")
	public void user_Navigate_to_the_URL_and_Login_to_the_Application(DataTable Credentials) throws Throwable {
		initialization();
		CRMLoginPageClass Login = new CRMLoginPageClass();
		for(Map<String,String> Data : Credentials.asMaps(String.class,String.class))
		{
			Login.username.sendKeys(Data.get("Username"));
			Login.password.sendKeys(Data.get("Password"));
		}
		Login.login_button.click();
		
	}
	
	
	
	

	
	
	

}
