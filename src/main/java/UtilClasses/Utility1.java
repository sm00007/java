package UtilClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility1 {
	public static void moveToElement(WebDriver driver,WebElement element)
	{
		Actions act =new Actions(driver);
		act.moveToElement(element).pause(2000).build().perform();
	}
	public static void moveByOffset(WebDriver driver)
	{
		Actions act =new Actions(driver);
		act.moveByOffset(400,500).pause(2000).build().perform();
	}
	
	public static void implicitwait(int time,WebDriver driver)
	{driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));	
	}
	public static boolean  isElementVisible(WebDriver driver,WebElement element)
	{
		@SuppressWarnings("deprecation")
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
			
	}
	public static List<String> getdata(int firstrow,int lastrow) throws EncryptedDocumentException, IOException
	{
		FileInputStream file =new FileInputStream("src\\main\\resources\\Datasheets\\product.xlsx");
		List<String>dataList=new ArrayList<String>();
		Sheet sheet=WorkbookFactory.create(file).getSheet("Sheet2");
		for(int i=firstrow;i<=lastrow;i++)
		{ try {
			String str=sheet.getRow(i).getCell(1).getStringCellValue();
			dataList.add(str);
		}catch(Exception e)
		{
		long data=(long)sheet.getRow(i).getCell(1).getNumericCellValue();
			String str1=String.valueOf(data);
			dataList.add(str1);
		}
		
		}
		return dataList;
	}
	public static void screenshot(WebDriver driver) throws InterruptedException, IOException
	{
		SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		   Date dat=new Date();
		   String str =sdf.format(dat);
		   TakesScreenshot tk=(TakesScreenshot)driver;
		   Thread.sleep(9000);
		   File source =(tk).getScreenshotAs(OutputType.FILE);
		   File desti=new File("C:\\Users\\Santy\\Desktop\\java\\screenshot\\sm"+str+".jpg");
		   String path=desti.getAbsolutePath();
		   FileHandler.copy(source, desti);
	}
	public static void scrolldown(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		   js.executeScript("window.scrollBy(0,1200)");
//		   Thread.sleep(1000);
//		   js.executeScript("window.scrollBy(0,600)");
//		   Thread.sleep(1000);
		   
		   WebElement a1 =driver.findElement(By.xpath("//span[text()='Phonepe UPI']"));
		   js.executeScript("arguments[0].scrollIntoView[true]",a1);
		   a1.click();
		   Thread.sleep(2000);
	}
public String screenCpature(WebDriver driver) throws IOException {
		
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("MM-dd-mm-hh-ss").format(date);
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("screenshot1\\screenshot" + modifiedDate +".png");
		String path = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return path;
		}

}
