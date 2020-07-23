package com.project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.project.base.BasePageObject;

public class LoginPage extends BasePageObject<LoginPage>{
	private By emailfield=By.xpath("//input[@id='username']");
	private By passwordfield=By.xpath("//input[@id='password']");	
	private By loginButton= By.xpath("//button[text()='LOGIN']");
	Logger log;
	
	public LoginPage(WebDriver driver, Logger log) {
		super(driver);
		this.log=log;
		// TODO Auto-generated constructor stub
	}



	public void openLoginPage(String url) {
		log.info("opening loginpage--");
		getPage(url);
	}
	public void fillupEmailAndPassword(String email,String pswd) {
		log.info("fill up email and password--");
		type(email,emailfield);
		type(pswd,passwordfield);
		
	}
	public WelcomePage pushSigninButton() {
		log.info("clicking on SignInButton--");
		click(loginButton);
		return new WelcomePage(driver);
	}
	
}
