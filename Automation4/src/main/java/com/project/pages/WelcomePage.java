package com.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.base.BasePageObject;

public class WelcomePage extends BasePageObject<WelcomePage>{

	
	private By enterNewItem=By.xpath("//*[text()='Enter a New Item']");
	private By titleField=By.xpath("");
	private By descriptionField=By.xpath("");
	private By addToDoField=By.xpath("");
	private By deleteLink=By.xpath("");
	private By logoutlink=By.xpath("");
	private By addedElement=By.xpath("");
	private By LinkPanel=By.xpath("");
	public By All=By.linkText("");
	
	public WelcomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	 public void waitForWelcomePageToLoad() {
		 waitForVisibilityOf(enterNewItem, 20);
	 }
	 public void addNewItem(String newItemTxt,String descriptionText) {
		 click(enterNewItem);
		 type(newItemTxt, titleField);
		 type(descriptionText,descriptionField);
		 
		 
	 }
	 public void deleteItem(String newItemTxt,String descriptionText) {
		 addNewItem(newItemTxt, descriptionText);
		 click(deleteLink);	 
	 }
	 public boolean findLogout() {
		return isElementPresent(logoutlink);
	 }
	 public String getActualTextOfaddedElement() {
		return getText(addedElement);
		 
	 }
/*	 public List<WebElement> getLinksHeader(){
		 
		return getElements(LinkPanel);
		 
	 }*/
	 public boolean IsLinkDisplayed(By element) {
		return isElementPresent(element);
		 
	 }
	 
}
