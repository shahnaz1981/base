package com.health.Health;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\mohamed .LAPTOP-QCE4AIJL\\eclipse-workspace\\Health\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://www.facebook.com");
	boolean b1=driver.findElement(By.tagName("a")).isDisplayed();
	System.out.println(b1);
	
	 List<WebElement>linkList=driver.findElements(By.tagName("a"));
	 System.out.println(linkList.size());
	 for(int i=1;i<linkList.size();i++) {
		 System.out.println(linkList.get(i).getText());
		 
	 }
	 List<WebElement>pic=driver.findElements(By.tagName("img"));
	 System.out.println(pic.size());
	 for(int i=1;i<pic.size();i++) {
		 System.out.println(pic.get(i).toString());
		  
	 
	 
 }	
	driver.close();	

	}

}
