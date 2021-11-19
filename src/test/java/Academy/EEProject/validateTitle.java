package Academy.EEProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateTitle extends base {
	 public WebDriver driver;
	
	 
	public static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage l;
      
    @BeforeTest
	
	public void initialize() throws IOException
	{
		driver = initialzeDriver();
	     log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	
	@Test
	
	public void validateAppTitle() throws IOException 
	{
		//for invoke method
		//one is inheritance
		//creating object to that class and invoke methods of it
		
		 l = new LandingPage(driver);
		//compare the text from the browser with actual text - error
	     
	     Assert.assertEquals(l.getTitle().getText(), "FEATURE COURSES");
//	     log.info("successfully validated text message");
	     
	}
	
	@Test
	public void validateHeader() throws IOException 
	{
		
	     
	     Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");

	     
	}
    @AfterTest
	
	public void teardown()
	{
		driver.close();
	}
	
	}
	
	
	
