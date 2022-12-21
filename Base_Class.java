package com.baseclass.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class Base_Class {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Javed\\eclipse-workspace\\Selenium_Automation_Tool\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Incognito");
		
		driver = new ChromeDriver(options);
		driver.get("https://phptravels.com/demo/");
		driver.manage().window().maximize();
		
		WebElement signUp = driver.findElement(By.xpath("(//a[.='Sign Up'])[2]"));
		signUp.click();
		
		Thread.sleep(4000);
		screenshot("URL page");
		
		single_WindowHandling(signUp);
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		send_Values(FirstName, "MoJA");
		
		WebElement LastName = driver.findElement(By.xpath("//input[@id='inputLastName']"));
		send_Values(LastName, "Javed");
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		send_Values(email, "mojavef37@gmail.com");
		
		WebElement countrycode = driver.findElement(By.xpath("(//div[.='+92'])[2]"));
		countrycode.click();
		
		WebElement india = driver.findElement(By.xpath("//span[contains(text(),'India (भारत)')]"));
		india.click();
		
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@type='tel']"));
		send_Values(phoneNumber, "9342375959");
		
		WebElement companyName = driver.findElement(By.xpath("//div[@class='card-body p-4']//descendant::input[@name='companyname']"));
		send_Values(companyName, "Greens Technologies");
		
		WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
		send_Values(address1, "Greens Technologies adyar branch");
		
		WebElement address2 = driver.findElement(By.xpath("//label[@for='inputAddress2']//following-sibling::input[@name='address2']"));
		send_Values(address2, "Greens Technologies anna nagar branch");
		
		WebElement city = driver.findElement(By.xpath("//input[@id='inputCity']"));
		send_Values(city, "Chennai");
		
		WebElement state = driver.findElement(By.xpath("//div[@class='col-sm-5']//descendant::input[@name='state']"));
		send_Values(state, "TamilNadu");
		
		WebElement postcode = driver.findElement(By.xpath("//input[@name='postcode']"));
		send_Values(postcode, "600048");
		
		WebElement country = driver.findElement(By.xpath("//select[@id='inputCountry']"));
		country.click();
		dropdown_Values(country, "IN");
		
		WebElement whatsappNumber = driver.findElement(By.xpath("//input[@name='customfield[2]']"));
		send_Values(whatsappNumber, "9342375858");
		
		WebElement password = driver.findElement(By.xpath("//div[@class='form-group prepend-icon']//descendant::input[@name='password']"));
		send_Values(password, "Array[]={JAVED7};");
		
		WebElement confirmpassword = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
		send_Values(confirmpassword, "Array[]={JAVED7};");
		
		WebElement noEmails = driver.findElement(By.xpath("//span[.='Yes']"));
		noEmails.click();
			
		Thread.sleep(13000);
		screenshot("Regsiter-page");
		
		current_Title();
		
		WebElement registerBTN = driver.findElement(By.xpath("//input[@value='Register']"));
		registerBTN.click();
		
		WebElement Order = driver.findElement(By.xpath("(//a[@menuitemname='Order New Services'])[1]"));
		Order.click();
		
		WebElement Mobile = driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		Mobile.click();
		
		current_Title();
		
		screenshot("MY account");
		
		WebElement orderNow1 = driver.findElement(By.xpath("//a[@id='product1-order-button']"));
		orderNow1.click();
				
		screenshot("Order details");
		WebElement addtoCart = driver.findElement(By.xpath("//div[@class='panel-add']"));
		addtoCart.click();
		
		WebElement ContinueBTN = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
		ContinueBTN.click();
		
		screenshot("Order Summary");
		
//		WebElement checkout = driver.findElement(By.xpath("//a[@id='checkout']"));
//		right_Click(checkout);
//		down_Enter();
//		
//		screenshot("Checkout Order");
//		
//		WebElement completeorderBTN = driver.findElement(By.xpath("//button[@id='btnCompleteOrder']"));
//		completeorderBTN.click();
//		
//		screenshot("INVOICE BILL");
		
		}
		
	public static void right_Click(WebElement element) {
		
		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();
	}
	public static void down_Enter() throws AWTException {
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void dropdown_Values(WebElement element, String name) {
		
		Select s = new Select(element);
		s.selectByValue(name);
		
	}
	
	public static void screenshot(String path) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Javed\\eclipse-workspace\\Selenium_Automation_Tool\\Screenshot\\"+ path +".png");
		FileUtils.copyFile(src, des);
	}
	
	public static void current_Title() {
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
	}

	public static void send_Values(WebElement element, String values) {

		element.sendKeys(values);
		
	}
	
	public static void single_WindowHandling(WebElement element) {

		String registerpage = driver.getWindowHandle();
		System.out.println(registerpage);
		
		Set<String> all_ID = driver.getWindowHandles();
		System.out.println(all_ID);
		
		for (String register_ID : all_ID) {
			if (register_ID.equals(registerpage)) {
				continue;
			}
			else {
				driver.switchTo().window(register_ID);
				
			}
			
		}
		
	}	
	
		
		
	
	
	
		
		
		
		
	}
