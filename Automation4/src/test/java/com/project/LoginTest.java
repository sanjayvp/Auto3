package com.project;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.LoginPage;
import com.project.pages.WelcomePage;



public class LoginTest extends BaseTest {
	public String Loginurl="";
	public String email="";
	public String password="";
	public WelcomePage welcomepg;
	public String newItem="test1";
	public String description="How will it can be done ? ";
	
	@Test
	public void verifyLogin() {
		LoginPage loginpg=new LoginPage(driver,log);
		loginpg.openLoginPage(Loginurl);
		
		loginpg.fillupEmailAndPassword(email, password);
		welcomepg=loginpg.pushSigninButton();
		welcomepg.waitForWelcomePageToLoad();
		log.info("verifying whether logout link is displayed");
		Assert.assertTrue(welcomepg.findLogout(), "As logout button is not displayed , login test is fail");
		
	}
	@Test
	public void verifyAddNewItem() {
		verifyLogin();
		welcomepg.addNewItem(newItem, description);
		String actText=welcomepg.getActualTextOfaddedElement();
		Assert.assertEquals(actText, newItem, "Test Failed as added new item is not submitted");
	}
	
	public void VerifyLinkDisplayedWelcomePage () {
		verifyLogin();
		boolean b=welcomepg.IsLinkDisplayed(welcomepg.All);
		Assert.assertTrue(b);
	}

}
