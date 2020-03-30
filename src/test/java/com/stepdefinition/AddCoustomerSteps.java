package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCoustomerSteps {
	static WebDriver driver;
	@Given("User launches demo telecom site")
	public void user_launches_demo_telecom_site() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maruthu\\eclipse-workspace\\cucumber\\src\\main\\driver\\chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.get("http://demo.guru99.com/telecom/index.html");
	   Thread.sleep(3000);
	  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
		 driver.findElement(By.xpath("//div[@id='closeBtn']")).click();;
	  driver.switchTo().parentFrame();
	}

	@Given("User click on add coustomer button")
	public void user_click_on_add_coustomer_button() throws Throwable {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
		 Thread.sleep(5000);
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
		 driver.findElement(By.xpath("//div[@id='closeBtn']")).click();;
		  driver.switchTo().parentFrame();
		}

	@When("User enter all the fields")
	public void user_enter_all_the_fields() {
		driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();;
		driver.findElement(By.id("fname")).sendKeys("maruthu");
		driver.findElement(By.id("lname")).sendKeys("pandi");
		driver.findElement(By.id("email")).sendKeys("pandi@gmail.com");
		driver.findElement(By.name("addr")).sendKeys("tirunelveli");
		driver.findElement(By.id("telephoneno")).sendKeys("12233334444");
	   
	}

	@When("User click on subit button")
	public void user_click_on_subit_button() {
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		
	   
	}

	@Then("User should be displayed coustomer ID is generated or not")
	public void user_should_be_displayed_coustomer_ID_is_generated_or_not() throws Throwable  {
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
		String text = driver.findElement(By.xpath("(//td[@align='center'])[2]")).getText();
		System.out.println(text);
	}



}
