package com.flipkart.app.automation.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.flipkart.uiautomation.Page;
import com.flipkart.uiautomation.TestSession;

public class FlipkartHomeScreenPOM extends Page{

	public FlipkartHomeScreenPOM(TestSession session) throws Exception {
		super(session, "ElementLocators");
	}
	
	public void clickOnHamburgerMenuButton() {
		WebElement ele = element("hamburger_element");
		waitForElementToBeClickable(ele, 25);
		element("hamburger_element").click();
	}
	
	public void clickOnProductSearchButton() {
		WebElement ele = element("products_search_element");
		waitForElementToBeClickable(ele, 25);
		element("products_search_element").click();
	}
	
	

}
