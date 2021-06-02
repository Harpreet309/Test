package utility;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src//main//resources//Features" ,
		glue = {"StepDefs"},
		dryRun = false,
		strict = true,
		monochrome = true,
		plugin = {"pretty",
				"com.cucumber.listener.ExtentCucumberFormatter:target//html//ExtentReport.html"}
		
		)
public class TestRunner {

	@AfterClass
	public static void writeExtentReport()
	
	{
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")) + "//src//main//resources//Config//config-extent.xml");
		Reporter.setSystemInfo("User name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Appliction Name", "Google");
		Reporter.setSystemInfo("Operation System", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "UAT04");

 } 
}
