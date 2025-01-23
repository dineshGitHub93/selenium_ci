package jenkinsci;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FirstCI {
	
	public WebDriver driver;
	public ExtentReports extentreport;
	private ExtentTest test;

	
	  @Test
	  public void openMyBlog() {
		  // Start logging for this test case
	    test = extentreport.createTest("exampleTest", "Sample Test for ExtentReports");
		driver.get("https://www.softwaretestingmaterial.com/");
		 // Log various steps in the test
        test.info("Test started");
        test.pass("This step passed successfully");
        test.info("Test finished");
	  }
	  
	  @BeforeClass
	  public void beforeClass() {
		  
		  //System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Drivers\\geckodriver.exe");
		// Create a Spark Reporter to generate an HTML report
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
	        sparkReporter.config().setDocumentTitle("Test Automation Report");
	        sparkReporter.config().setReportName("Extent Report Example");

	        // Create an ExtentReports object and attach the reporter
	        extentreport = new ExtentReports();
	        extentreport.attachReporter(sparkReporter);

	        // Add system/environment info to the report
	        extentreport.setSystemInfo("OS", "Windows 10");
	        extentreport.setSystemInfo("Tester", "Dinesh");
	        extentreport.setSystemInfo("Java Version", System.getProperty("java.version"));
	    
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
