package com.flipkart.app.automation.validators;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.flipkart.uiautomation.Page;
import com.flipkart.uiautomation.TestSession;

public class FlipkartHomeScreenValidator extends Page {

	/* Initialisation of Ajax Page */
	public FlipkartHomeScreenValidator(TestSession session) throws Exception {
		super(session, "ElementLocators");
	}

	public void verifyHomeScreenDisplayed() {
		 Assert.assertTrue(element("hamburger_element").isDisplayed(),"Flipkart Home Page is displayed");
	}

	public void verifyChooseLanguageDisplayed() {
		Assert.assertTrue(element("choose_language_element").isDisplayed(),"Choose Language option is displayed");
	}
	
	/*
	 *  @description: Verifies the Product Search button displayed.
	 */
	public void verifyProductSearchButtonDisplayed() {
		//wait for element visibilty
		new WebDriverWait(session.driver, 10).until(ExpectedConditions.visibilityOf(element("products_search_element")));
	    //Verify element displayed
		Assert.assertTrue(element("products_search_element").isDisplayed(), "Procduct Search Element is Not displayed");
	}
	
	
}
