package com.health.Health;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
//What is synchronization?
//It is a mechanism which involves more than one components to work parallel with Each other.

/*Generally in Test Automation, we have two components
1. Application Under Test.
2. Test Automation Tool--Selenium. */
public class App {

    public static void main( String[] args ) {
  System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohamed .LAPTOP-QCE4AIJL\\eclipse-workspace\\Health\\driver\\chromedriver.exe");  
   WebDriver driver=new ChromeDriver(); 
   driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   
   //implicitly wait -- is always applied globally --is available for all the webelements
   //dynamic in nature
   // it can be changed anywhere and at any time in your code.
   
   driver.get("https://www.facebook.com/");
   WebElement firstName=driver.findElement(By.name("firstname"));
   WebElement lastName=driver.findElement(By.name("lastname"));
   WebElement mobileNo=driver.findElement(By.name("reg_email__"));
   WebElement password=driver.findElement(By.name("reg_passwd__"));
   
   //Explicit Wait:
   //1.no explicit keyword or method
   //2.available with WebdriverWait with some ExpectedConditions
   //3.specific to element
   //4.dynamic in nature
   //5.we should never use implicit wait and explicit wait together:selenium
  // WD will wait for the element first because of impli wait and then the Explicit wait
   //so the total sync wait will be increased for each element
   
   
   
   sendKeys(driver,firstName,10,"tom");
   sendKeys(driver,lastName,5,"peter");
   sendKeys(driver,mobileNo,3,"05078");
   sendKeys(driver,password,2,"123xz");
   
    	
    	}
    
 public static void sendKeys(WebDriver driver,WebElement element,int timeOut,String value) {
	
	new WebDriverWait(driver,timeOut).until(ExpectedConditions.visibilityOf(element));
	element.sendKeys(value);
 }   
 public static void clickOn(WebDriver driver,WebElement element,int timeout) {
		
	new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
	element.click();
 }   
    
    
}
