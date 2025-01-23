package jenkinsci;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstCI {
	
	public WebDriver driver;
	
	  @Test
	  public void openMyBlog() {
		driver.get("https://www.softwaretestingmaterial.com/");
	  }
	  
	  @BeforeClass
	  public void beforeClass() {
		  
		  //System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Drivers\\geckodriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
