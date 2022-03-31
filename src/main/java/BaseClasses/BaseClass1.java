package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass1
{
	public static WebDriver getWebDriver(String a)
	{    if(a.equals("chrome"))
	{
		   //syso
		//syso
		
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Browsers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://flipkart.com/");
		driver.manage().window().maximize();
		
		return driver;}
		
	else
	{
		System.setProperty("webdriver.gecko.driver","src\\main\\resources\\Browsers\\x\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://flipkart.com/");
		driver.manage().window().maximize();
		
		return driver;
	}}

}
