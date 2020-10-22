package Utility;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
		retryCount = 2,
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		usageReport = true,
		toPDF = true,
		outputFolder = "target"
	
		)
@CucumberOptions
(
		features = "src//main//resources//FeatureFile" ,
		glue = {"StepDef"} ,
		plugin = {"pretty"}
		)


public class TestRetryRunner {

}
