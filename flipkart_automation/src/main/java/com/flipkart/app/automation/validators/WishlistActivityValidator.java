package com.flipkart.app.automation.validators;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.flipkart.uiautomation.Page;
import com.flipkart.uiautomation.TestSession;

public class WishlistActivityValidator extends Page {

	/* Initialisation of Page Class */
	public WishlistActivityValidator(TestSession session) throws Exception {
		super(session, "ElementLocators");
	}

	/*
	 *  @description: Verifies the Search textbox element displayed.
	 */
	public void verifySearchTextBoxDisplayed() {
		//wait for element visibilty
		new WebDriverWait(session.driver, 10).until(ExpectedConditions.visibilityOf(element("search_textbox_element")));
	    //Verify element displayed
		Assert.assertTrue(element("search_textbox_element").isDisplayed(), "Search Textbox element is Not displayed");
	}

	
}
