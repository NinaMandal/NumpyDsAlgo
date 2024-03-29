package Runner;


	
	
	
	import io.cucumber.testng.AbstractTestNGCucumberTests;

	import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
			//features="C:\\Users\\dimpl\\OneDrive\\Documents\\NumpyNinja\\Practice1\\NumpyDsAlgo\\src\\test\\java\\FeatureFiles\\LoginFeature.feature", 
			features="C:\\Users\\dimpl\\OneDrive\\Documents\\NumpyNinja\\Practice1\\NumpyDsAlgo\\src\\test\\java\\FeatureFiles\\registerFeature.feature",
			glue={"StepDefinitions", "hooks"},
			monochrome=true,//display the console output in a proper readable format
			plugin= {"pretty","html:target/cucumber.html","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},//different types of reporting
			dryRun=false ,//it will mapping is proper between feature file and step definition file
			publish=true)//Will generate report link in console
	public class TestRunner extends AbstractTestNGCucumberTests {

	


}