package TestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClasses.BaseClass1;
import PomClasses.HomePage;
import PomClasses.LoginPage;
import PomClasses.ProfllePage;



public class Test1 {
	WebDriver driver;
	LoginPage loginpage;
	HomePage hp;
	ProfllePage pp;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String a)
	{
		driver=BaseClass1.getWebDriver(a);
	}
	@BeforeMethod
	public void beforemethod()
	{
		loginpage= new LoginPage(driver);
		hp= new HomePage(driver);
		pp= new ProfllePage(driver);
	}
	@Test
	public void VerifyUserLogIn() throws InterruptedException
	{
		
		  //pass driver as argument

		loginpage.enterMailId();
        Reporter.log("Entered emailid");
		loginpage.enterPassword();
		 Reporter.log("Entered pass");
		loginpage.clickSubmitButton();
		 Reporter.log("submit");
		hp.hovertoprofilename();
		String txt=hp.getlogoutText();
		
		if(txt.equals("Logout"))
		{
			System.out.println("test passed");
		}
		else {
			Assert.fail();
		}		
	}
	
	public void verifyUserCanAddAddress() throws EncryptedDocumentException, IOException, InterruptedException
    { hp.movePointer();
		hp.hovertoprofilename();
    hp.ClickOnMyProfileText();
   
    pp.clickOnmanageAddress();
    pp.clickOnAddNewAddress();
   // pp.getDataForAddress();
	pp.AdressField();
	pp.ClickOnRadio();
	pp.ClickOnSave();
 	   
    }
	
//	@AfterClass
//	public void close1()
//	{
//		driver.close();
//		
//	}



}
