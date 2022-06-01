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
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricletBatvalidation {
	
	static WebDriver d;
	
	@BeforeClass
	public static void UserLaunch() throws Exception {
		
		WebDriverManager.chromedriver().setup();
 		d = new ChromeDriver();
 		d.get("https://www.flipkart.com/");
 		d.manage().window().maximize();
 		Thread.sleep(3000);
		}
	@AfterClass
	public static void After() {
		d.quit();
		
	}
	
	@BeforeMethod
	public void Start() {
		System.out.println("Starttime");
		}
	@AfterMethod
	public void End() {
		System.out.println("Endtime");
		}
	@Test(priority=1,groups = "smoke")
	public void Login() throws Exception {
		WebElement email= d.findElement(By.xpath("//*[text()='Login']//following::input[1]"));
		email.sendKeys("9080655955");
		d.findElement(By.xpath("//*[text()='Login']//following::input[2]")).sendKeys("9080655955");
		d.findElement(By.xpath("(//*[text()='Login'])[3]")).click();
		Thread.sleep(3000);
		}
	@Test(priority=2,groups = "smoke")
	public void Search() throws Exception {
		d.findElement(By.xpath("//*[@type='text']")).sendKeys("Cricket Bat");
		d.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		}
	@Test(priority=3)
	public void Userclick() {
		d.findElement(By.xpath("(//*[@class='s1Q9rs'])[1]")).click();
		String Pw = d.getWindowHandle();
		Set<String> Cw = d.getWindowHandles();
		for (String C : Cw) {
			if(!C.equals(Pw)){
				d.switchTo().window(C);
			}}
		}
	@Test(priority=4)
	public void Purchase() throws Exception {
		d.findElement(By.xpath("//*[@class='_36yFo0']")).sendKeys("600020");
		d.findElement(By.xpath("//*[@class='_2P_LDn']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[text()='3']")).click();
		Thread.sleep(6000);
		d.findElement(By.xpath("//*[text()='ADD TO CART']")).click();
		Thread.sleep(3000);
		}
	@Test(priority=5)
	public void PlaceOrder() {
		
		d.findElement(By.xpath("//*[text()='Place Order']")).click();
		
		}

}
