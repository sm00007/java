package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.Utility1;

public class HomePage extends Utility1 {

	WebDriver driver;
	@FindBy(xpath="//input[@class='_3704LK']")
	private WebElement searchField;
	@FindBy(xpath="//img[@title='Flipkart']")
	private WebElement icon;
	@FindBy(xpath="//div[text()='Mobiles']")
	private WebElement mobiletext;
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactus;
	@FindBy(xpath="//div[text()='SANTOSH']")
	private WebElement profile;
	@FindBy(xpath="//li[@class='_2NOVgj'][10]")
	private WebElement logouttext;
	@FindBy(xpath="//li[@class='_2NOVgj'][1]")
	private WebElement myprofletext;

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void hovertoprofilename()
	{
		isElementVisible(driver,profile);
		 moveToElement(driver,profile);	 
	}
	public void ClickOnMyProfile()
	{
		 isElementVisible(driver,profile);
		 profile.click();
	}
	public void ClickOnMyProfileText()
	{
		 isElementVisible(driver,myprofletext);
		 myprofletext.click();
		 implicitwait(3,driver);
	}
	public String getlogoutText()
	{
		String k=logouttext.getText();
		return k;
	}
	
	
	public void movePointer() throws InterruptedException
	{
		moveByOffset(driver);
		Thread.sleep(3000);
	}
//	public String ispageloaded()
//	{
//		//WebElement element=explicitwait(driver,mobiletext,10);
//		String text=element.getText();
//		return text;
//	}
	public void clickoncontactus()
	{scrollToElement(contactus);
		contactus.click();
	}
	private void scrollToElement(WebElement contactus2) {
		// TODO Auto-generated method stub
		
	}

}
