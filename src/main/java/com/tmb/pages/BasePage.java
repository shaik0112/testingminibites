package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;

public class BasePage {

	/**
	 * Locates element by given wait strategy, performs the clicking operation on webelement and
	 * writes the pass even to the extent report.
	 * @author Amuthan Sakthivel
	 * Jan 22, 2021
	 * @param by By Locator of the webelement
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.tmb.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	protected void click(By by, WaitStrategy waitstrategy,String elementname) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.click();
		ExtentLogger.pass(elementname+" is clicked",true);
		
	}

	/**
	 * Locates element by given wait strategy, sends the value to located webelement and
	 * writes the pass even to the extent report.
	 * @author Amuthan Sakthivel
	 * Jan 22, 2021
	 * @param by By Locator of the webelement
	 * @param value value to be send the text box
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.tmb.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	protected void sendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		ExtentLogger.pass(value +" is entered successfully in "+elementname, true);
	}
	
	/**
	 * Return page title of webpage in String
	 * 
	 * @author Amuthan Sakthivel
	 * Jan 22, 2021
	 * @return Page title of the webpage where the selenium is currently interacting.
	 */
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	
}
