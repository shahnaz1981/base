package com.health.Health;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	

	public static void main(String[] args)throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohamed .LAPTOP-QCE4AIJL\\eclipse-workspace\\Health\\driver\\chromedriver.exe");
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.freecrm.com"); //enter URL
		//driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
//		driver.findElement(By.name("username")).sendKeys("naveenk");
//		driver.findElement(By.name("password")).sendKeys("test@1234");
		//driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		//executeScript -- to execute JavaScript code/html/body/div[1]/header/div/nav/div[2]/div/a/span[1]
		
		//WebElement loginBtn = driver.findElement(By.xpath("//input[contains(@type,'submit')]")); //login button
		WebElement loginBtn = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/a/span[1]")); //login button
		
		
		
		flash(loginBtn, driver); //highlight the element
		
		drawBorder(loginBtn, driver); //draw a border
		//take screenshot:
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
	   FileUtils.copyFile(src, new File("C:\\Users\\mohamed .LAPTOP-QCE4AIJL\\eclipse-workspace\\Health\\src\\main\\java\\com\\health\\Health\\element.png"));
		//generate Alert
		//generateAlert(driver, "There is an issue with Login button on Login Page");
		
		//click on any element by using JS executor
		//clickElementByJS(loginBtn, driver);
		
		//refresh the page:
		//1. by using selenium:
		//driver.navigate().refresh(); 
		
		//2. by using JS executor:
		//refreshBrowserByJS(driver);
		
		//get the tile of the page by JS:
		//System.out.println(getTitleByJS(driver));
		
		//get the page text:
	//	System.out.println(getPageInnerText(driver));
		
		//scroll page down:
		scrollPageDown(driver);
		//Thread.sleep(5000);
		
		//WebElement forgotPwdLink = driver.findElement(By.linkText("info@freecrm.com"));
	    WebElement registration = driver.findElement(By.xpath("/html/body/div[1]/main/section[3]/div/div[2]/div/div/div/div/a/span[2]"));
	    scrollIntoView(registration, driver);
		
	}
	
	
	public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i <  10; i++) {
            changeColor("rgb(0,200,0)", element,driver);//1
            changeColor(bgcolor, element,driver);//2
        }
    }
    public static void changeColor(String color, WebElement element, WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
     }
	
	
    public static void drawBorder(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
    
    public static void generateAlert(WebDriver driver, String message){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("alert('"+message+"')");

    }
    
    public static void clickElementByJS(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].click();", element);
    	
    }
	
    public static void refreshBrowserByJS(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("history.go(0)");
    }
    
    public static String getTitleByJS(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	String title = js.executeScript("return document.title;").toString();
    	return title;
    }
    
    public static String getPageInnerText(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	String pageText = js.executeScript("return document.documentElement.innerText;").toString();
    	return pageText;
    }
    
    public static void scrollPageDown(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    public static void scrollIntoView(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    


		
		
		
		
		
		
		
		
		
	}


