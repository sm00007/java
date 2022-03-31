package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	
	public class LoginPage {  
		
		WebDriver driver;
		@FindBy(xpath="(//input[@type='text'])[2]")
		private WebElement emailId;
		@FindBy(xpath=("//input[@type='password']"))
		private WebElement password;
		@FindBy(xpath=("(//button[@type='submit'])[2]"))
		private WebElement loginbttn;
		public LoginPage(WebDriver driver)
		{PageFactory.initElements(driver,this);
		this.driver=driver;
		}
		public void enterMailId() throws InterruptedException {
			emailId.sendKeys("7588757293");
			
			//System.out.println(emailId.getText());
			Thread.sleep(2000);
			
			
		}
	public void enterPassword() throws InterruptedException {
		password.sendKeys("santy@123");
		Thread.sleep(2000);
			
		}
	public void clickSubmitButton() throws InterruptedException {
		loginbttn.click();
		Thread.sleep(2000);
		
	}


}
