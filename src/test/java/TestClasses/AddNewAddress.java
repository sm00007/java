package TestClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.profiler.model.Profile;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseClasses.BaseClass1;
import PomClasses.HomePage;
import PomClasses.LoginPage;
import PomClasses.ProfllePage;
import UtilClasses.Utility1;



@SuppressWarnings("unused")
public class AddNewAddress {
	WebDriver driver;
	LoginPage loginpage;
	HomePage hp;
	ProfllePage pp;
	ExtentReports reports;
	ExtentTest test;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String a)
	{ 
		reports = new ExtentReports("ExtentReports.html",true);
		test = reports.startTest("AddNewAddress");
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
		Assert.assertEquals(txt, "Logout");	
		
		test.log(LogStatus.PASS, "Log in Test Passed");
//		if(txt.equals("Logout"))
//		{
//			System.out.println("test passed");
//		}
//		else {
//			AssertJUnit.fail();
//		}		
	}
	@DataProvider(name="dataSet")
	public String[][] dataToTest()
	{
		String[][] data = {{"Sanket", "9845126666", "411057", "Hijewadi"},  {"Atul", "8734555555", "411052", "phase1"}};
		return data;
	}
	@Test(priority=1, dataProvider="dataSet", dependsOnMethods="VerifyUserLogIn")
	public void verifyUserCanAddAddress(String name, String mobNumber, String pincode, String locality) throws EncryptedDocumentException, IOException, InterruptedException
    { hp.movePointer();
		hp.hovertoprofilename();
    hp.ClickOnMyProfileText();
   
    pp.clickOnmanageAddress();
    pp.clickOnAddNewAddress();
    
    List<String> dataList = new ArrayList<String>();
	dataList.add(name);
	dataList.add(mobNumber);
	dataList.add(pincode);
	dataList.add(locality);
    pp.getDataForAddresss(dataList);
	pp.AdressField();
	pp.ClickOnRadio();
	pp.ClickOnSave();
	
	test.log(LogStatus.PASS, "Added new Address");
 	   
    }
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException
{
		if(result.getStatus() == ITestResult.FAILURE)
	{
		test.log(LogStatus.FAIL, test.addScreenCapture(((Utility1) pp).screenCpature(driver)), "Taken Screenshot");
		}
	}
	
	@AfterClass
	public void afterClass()
	{
		reports.endTest(test);
		reports.flush();
		
		//driver.quit();
	}


}
