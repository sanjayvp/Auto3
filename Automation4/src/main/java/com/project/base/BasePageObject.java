package com.project.base;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {
	protected WebDriver driver;
	protected WebDriverWait wait;

	// constructor
	protected BasePageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 40);
	}

	protected T getPage(String URL) {
		driver.get(URL);
		return (T) this;

	}

	protected void type(String text, By element) {
		find(element).sendKeys(text);
	}

	private WebElement find(By element) {
		return driver.findElement(element);

	}
	public void get(By element) {
		driver.findElement(element);
	}
	public boolean isElementPresent(By element) {
		return find(element).isDisplayed();
		
		
	}
	
	protected void click(By element) {
		find(element).click();
	}
	protected void waitForVisibilityOf(By locator,Integer...timeOutinSeconds) {
		int attempts=0;
		while (attempts<2) {
			try {
				
				waitfor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutinSeconds.length>0?timeOutinSeconds[0]:null));
				break;
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}
			attempts++;
		}
		
	}
	private void waitfor(ExpectedCondition<WebElement> condition,Integer timeOutInSeconds) {
		timeOutInSeconds=timeOutInSeconds!=null?timeOutInSeconds:30;
		WebDriverWait wait=new WebDriverWait(driver,timeOutInSeconds);
		wait.until(condition);
	}
	public String getTitle() {
		return driver.getTitle();
		
	}
	public String getText(By element) {
		return driver.findElement(element).getText();
		
	}
	public List<WebElement> getElements(By element){
		WebElement ele=driver.findElement(element);
		
		return ele.findElements(By.tagName("a"));
		
	}

}
