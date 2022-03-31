package PomClasses;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.Utility1;


public class ProfllePage extends Utility1 {
	WebDriver driver;
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageAddress;                   
	//giving xpath by using @FindBy so we will use only emailID and perform action on it.it will reduce rework/retype

	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement AddNewAddressText;
	@FindBy(xpath="//textarea[@name='addressLine1']")
	private WebElement Address;

	@FindBy(xpath="(//div[@class='_1XFPmK'])[1]")
	private WebElement RadioWork;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement Save;
	
	public ProfllePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void clickOnmanageAddress() throws InterruptedException
	{
		isElementVisible(driver,manageAddress);
		manageAddress.click();
	}
	public void clickOnAddNewAddress() throws InterruptedException
	{
		isElementVisible(driver,AddNewAddressText);
		AddNewAddressText.click();
	}
	public void getDataForAddresss(List<String>a) throws EncryptedDocumentException, IOException
	{
		//List<String>list=getdata(0,3);
		for(int i=1;i<=4;i++)
		{
			WebElement element=driver.findElement(By.xpath("((//form)[2]//input)["+i+"]"));
			element.sendKeys(a.get(i-1));
		}
		
	}
	public void AdressField()
	{
		Address.sendKeys("shahar peth basmath");
	}
	
	public void ClickOnRadio()
	{
		RadioWork.click();
	}
	
	public void ClickOnSave() throws InterruptedException
	{Thread.sleep(3000);;
		Save.click();
	}}
