package StepDefs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static ExtentReports extent;
    private static ExtentTest scenarioTest;

    @Before
    public void beforeScenario(Scenario scenario) {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/html/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);

            // System info
            extent.setSystemInfo("User Name", System.getProperty("user.name"));
            extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
            extent.setSystemInfo("Application Name", "HotelBooking");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Environment", "UAT04");
        }

        scenarioTest = extent.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioTest.fail("Scenario Failed");
        } else {
            scenarioTest.pass("Scenario Passed");
        }

        extent.flush();
    }
}
