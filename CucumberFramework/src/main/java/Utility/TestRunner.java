package Utility;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "src//main//resources//FeatureFile" ,
		glue = {"StepDef"} ,
		dryRun = false,
		strict = false,
		monochrome = true,
		plugin = {"pretty"
			//	"html:target//html-reports//",
			//	"json:target//json-reports//",
			//	"junit:target//junits-reports//report.xml",
			//	"usage:target//usage-reports//"
	//			"com.cucumber.listener.ExtentCucumberFormatter:target//html//ExtentReport.html"
				
		}
		)
public class TestRunner {
	

	/*@AfterClass
	public static void writeExtentReport()
	
	{
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")) + "//src//main//resources//ConfigFiles//config-extent.xml");
		Reporter.setSystemInfo("User name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Appliction Name", "Google");
		Reporter.setSystemInfo("Operation System", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "UAT04");

	
} */
	
	private TestNGCucumberRunner testNGRunner;
	
	@BeforeClass(alwaysRun=true)
	public void setup()
	{
		testNGRunner = new TestNGCucumberRunner(this.getClass());
	}
	@Test(groups="cucumber" , dataProvider="getFeatures")
	public void runFeature(CucumberFeatureWrapper wrapper)
	{
		testNGRunner.runCucumber(wrapper.getCucumberFeature());
	}
	@DataProvider(name="getFeatures")
	public Object[][] getFeatures()
	{
		return testNGRunner.provideFeatures();
	}
	
	@AfterClass
	public void teardown()
	{
		testNGRunner.finish();
	}
	
}
