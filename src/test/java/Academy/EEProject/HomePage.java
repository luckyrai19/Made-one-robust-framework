package Academy.EEProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
       public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
	public void initialize() throws IOException
	{
		driver = initialzeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username, String Password, String Text) throws IOException 
	{
		
		//for invoke method
		//one is inheritance
		//creating object to that class and invoke methods of it
		
		
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
	     LoginPage lp = l.getLogin();
	     lp.getEmail().sendKeys(Username);
	     lp.getPassword().sendKeys(Password);
	    
	 	log.info(Text);
	     lp.getLogin().click();
	     ForgotPassword fp =lp.forgotPassword();
	     fp.getEmail().sendKeys("abc@gmail.com");
	     fp.sendMeInstructions().click();
	     
	     
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//column stands for how many values per each test
		
		//Array size is 2
		// 0,1
		Object[][] data = new Object[2][3];
		//0th row
		
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";
		
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="7890";
		data[1][2]="Non Restricted User";
		
		return data;
		
		
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
