package com.project;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
WebDriver driver;
Logger log;
	
	
	@BeforeMethod
	public void setUp() {
		log=Logger.getLogger(".\\src\\main\\resources\\log4j.properties");
		log.info("Opening browser --");
		driver = new ChromeDriver();
		

	}
	@AfterMethod
	public void teardown() {
		log.info("Closing browser--");
		driver.quit();
	}

}


