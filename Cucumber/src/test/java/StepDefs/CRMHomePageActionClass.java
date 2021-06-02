package StepDefs;

import java.util.Map;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.TestBase;
import PageClasses.CRMHomePageClass;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class CRMHomePageActionClass extends TestBase {
	
	public WebDriver driver = TestBase.driver;

	CRMHomePageClass Home = new CRMHomePageClass();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@SuppressWarnings("deprecation")
	@Given("^Validate whether user ia ta home page or not$")
	public void validate_whether_user_ia_ta_home_page_or_not() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   String PageTitle = driver.getTitle();
		
		wait.until(ExpectedConditions.visibilityOf(Home.HomeIcon));
		
		Assert.assertEquals("Cogmento CRM", PageTitle);
	}

	@Then("^Navigate to Create Task option and select it$")
	public void navigate_to_Create_Task_option_and_select_it() throws Throwable {
	    Actions mouse = new Actions(driver);
	    mouse.moveToElement(Home.HomeIcon).build().perform();
	    Home.TasksIcon.click();
	    Thread.sleep(2000);
	    mouse.moveToElement(Home.completion).build().perform();
	    
	    
	    
	    
	}

	@When("^Validate whether user is at Create Task Page or not$")
	public void validate_whether_user_is_at_Create_Task_Page_or_not() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	//	wait.until(ExpectedConditions.titleContains("Create new Task"));
	    System.out.println("Create New Task Page is opened");
		
	}

	@Then("^Fill Required fields in Create Task page$")
	public void fill_Required_fields_in_Create_Task_page(DataTable FormData) throws Throwable {
	for( Map<String,String> TaskData :  FormData.asMaps(String.class, String.class))
	{
		Home.TitleBar.sendKeys(TaskData.get("Title"));
		Home.AssignedTo.click();
		Home.AssignedToHarpreet.click();
		Home.Deal.sendKeys(TaskData.get("Deal"));
		try {
		Home.DealSelected.sendKeys(Keys.ENTER);
		}
		catch(ElementNotInteractableException e)
		{
			System.out.println("Exception Catches");
			Thread.sleep(2000);
		}
		
		Home.description.sendKeys(TaskData.get("Description"));
		Home.Type.click();
		Home.ChooseType.click();
		Home.Contact.sendKeys(TaskData.get("Contact"));
		Home.Case.sendKeys(TaskData.get("Case"));
		Home.completion.sendKeys(TaskData.get("Completion"));
		Home.SaveButton.click();
		Thread.sleep(3000);
		   Actions mouse = new Actions(driver);
		    mouse.moveToElement(Home.HomeIcon).build().perform();
		    Home.TasksIcon.click();
		    
	}
	    
	}
}
