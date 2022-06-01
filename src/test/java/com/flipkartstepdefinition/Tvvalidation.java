package com.flipkartstepdefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tvvalidation {
	
	static WebDriver d;

	@BeforeClass
	public static void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
 		d = new ChromeDriver();
 		d.get("https://www.flipkart.com/");
 		d.manage().window().maximize();
 		Thread.sleep(3000);	
	}
	@AfterClass
	public static void After() {
		d.close();
		
		
	}
	@BeforeMethod
	public void StartTime() {
		System.out.println("Starttime");

	}
	@AfterMethod
	public void EndTime() {
		System.out.println("Endtime");
	}
	
	@Test(priority = 0)
	public  void UserLogin() {
		WebElement email= d.findElement(By.xpath("//*[text()='Login']//following::input[1]"));
		email.sendKeys("9080655955");
		d.findElement(By.xpath("//*[text()='Login']//following::input[2]")).sendKeys("9080655955");
		d.findElement(By.xpath("(//*[text()='Login'])[3]")).click();

	}
	@Test(priority = 1)
	public void UserSearch() throws Exception {
	    Thread.sleep(3000);

		d.findElement(By.xpath("//*[@type='text']")).sendKeys("Mi Tv 43inch");
		d.findElement(By.xpath("//*[@type='submit']")).click();
	}
	@Test(priority = 2)
	public void UserSelectTV() throws Exception {
		    Thread.sleep(3000);
			
			d.findElement(By.xpath("//*[contains(text(),'Xiaomi 5A 80')]")).click();
			String Pw = d.getWindowHandle();
			Set<String> Cw = d.getWindowHandles();
			for (String C : Cw) {
				if(!C.equals(Pw)){
					d.switchTo().window(C);
				}
				
			}}
	@Test(priority = 3)
	public void UserClicktoBuy() throws Exception {
		d.findElement(By.xpath("//*[@class='_36yFo0']")).sendKeys("600020");
		d.findElement(By.xpath("//*[@class='_2P_LDn']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[text()='GO TO CART']")).click();
	}
	@Test(priority = 4)
	public void UserPlaceorder() throws Exception {
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[text()='Place Order']")).click();
	
	}
}
