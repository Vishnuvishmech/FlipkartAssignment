package com.flipkart.app.automation.helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.flipkart.uiautomation.ActionUtils;
import com.flipkart.uiautomation.Page;
import com.flipkart.uiautomation.TestSession;

import io.appium.java_client.MobileDriver;

public class OnboardingFlipkartAppPOM extends Page {

	/* Initialisation of Page Class */
	public OnboardingFlipkartAppPOM(TestSession session) throws Exception {
		super(session, "OnboardingElements");
	}

	
	public void ClickonLanguageButton(){
		WebElement ele = element("english_lang_button");
		waitForElementToBeClickable(ele, 25);
		element("english_lang_button").click();
	}
	
	public void clickOnContinueButton() {
		WebElement ele = element("continue_button");
		waitForElementToBeClickable(ele, 25);
		element("continue_button").click();
	}
	
	
	public void scrollToElement(int maxScroll, double start, double end, String scrollType,String elementName,
			MobileDriver driver) throws Exception {

		while (maxScroll != 0) {
			try {
				System.out.println("Trying to locate the element");
				if (element(elementName).isDisplayed()) {
					maxScroll++;
					break;
				}
			}
			catch (NoSuchElementException e) {
					switch (scrollType.toUpperCase()) {
					case ("DOWN"):
						ActionUtils.swipeTopToBottom(1, driver, start, end);
						break;
					case ("UP"):
						ActionUtils.swipeBottomToTop(1, driver, start, end);
						break;
					case ("LEFT"):
						ActionUtils.swipeRightToLeft(1, start, end, driver);
						break;
					case ("RIGHT"):
						ActionUtils.swipeLefToRight(1, start, end, driver);
						break;
					default:
						break;
					}
					}
				}
	}
	
	public void clickOnUseEmailIDLink() {
		WebElement ele = element("use_email");
		waitForElementToBeClickable(ele, 25);
		element("use_email").click();
	}
	
	public void setLoginEmailID(String email) {
		WebElement ele = element("login_email");
		waitForElementToBeClickable(ele, 25);
		element("login_email").sendKeys(email);
	}
	
	
	public void setLoginPassword(String password) {
		WebElement ele = element("login_password");
		waitForElementToBeClickable(ele, 25);
		element("login_password").sendKeys(password);
	}
	
	public void clickOnEmailPasswordContinue() {
		WebElement ele = element("email_continue");
		waitForElementToBeClickable(ele, 25);
		element("email_continue").click();
	}
	
	public void PerformOnboarding(String email, String password) throws Exception {
		//Scroll till Bottom
		scrollToElement(10,  0.8,  0.4, "UP", "english_lang_button",session.driver);
		//Click On Language button
		ClickonLanguageButton();
		// Click on Continue Button
		clickOnContinueButton();
		// Click on Use Email ID link
		clickOnUseEmailIDLink();
		//Enter email ID for login
		setLoginEmailID(email);
		 // Click on Continue in Email screen
		 clickOnEmailPasswordContinue();
		 // Enter password for login
		 setLoginPassword(password); 
		// Click on Continue in Email screen
		 clickOnEmailPasswordContinue();
		 
		Thread.sleep(5000);
	}
}
