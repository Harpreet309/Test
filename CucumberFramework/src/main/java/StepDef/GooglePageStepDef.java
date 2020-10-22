package StepDef;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// import com.aventstack.extentreports.gherkin.model.Scenario;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GooglePageStepDef {
	WebDriver driver;
	 WebElement searchBar;
	 
	/* @Before
	 public void authorname()
	 {
		 Reporter.assignAuthor("Harpreet Singh");
	 } */
		
	@Given("^I launch the Chrome Browser$")
	public void i_launch_the_Chrome_Browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
	  
	  driver = new ChromeDriver();
	}
	 

	@When("^I open google page$")
	public void i_open_google_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 driver.get("https://www.google.com");
	}

	@Then("^It displays the search bar$")
	public void it_displays_the_search_bar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		 searchBar = driver.findElement(By.name("q"));
		 searchBar.sendKeys("Adhaar Card");
		
	    
	}

	@Then("^I validate the search bar$")
	public void i_validate_the_search_bar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(searchBar.isDisplayed()==true)
		{
			System.out.println("Validation Successfull");
		}
	 
	}

	@SuppressWarnings("deprecation")
	@Then("^I validate the search result$")
	public void i_validate_the_search_result() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		searchBar.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Adhaar Card - Google Search");
	//	Reporter.addStepLog("Page title validated");
	}
	
	@Then("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
		
	
}
	
/*	@After
	public void afterScenario(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			String scn = scenario.getName().replaceAll(" ", "_");
			
			File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			File destFile = new File(System.getProperty("user.dir") + "//target//html//" + scn +".png");
			
			FileUtils.copyFile(SrcFile, destFile);
			
			Reporter.addScreenCaptureFromPath(destFile.toString());
			
		}
	} */
}
	
