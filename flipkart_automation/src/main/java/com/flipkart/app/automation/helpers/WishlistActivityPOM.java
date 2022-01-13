package com.flipkart.app.automation.helpers;

import org.openqa.selenium.WebElement;

import com.flipkart.app.automation.validators.FlipkartHomeScreenValidator;
import com.flipkart.app.automation.validators.WishlistActivityValidator;
import com.flipkart.uiautomation.ActionUtils;
import com.flipkart.uiautomation.Page;
import com.flipkart.uiautomation.TestSession;

import io.appium.java_client.MobileDriver;

public class WishlistActivityPOM extends Page {

	WishlistActivityValidator wishlistActivityValidator;
	FlipkartHomeScreenValidator flipkartHomeScreenValidator;
	FlipkartHomeScreenPOM flipkartHomeScreenPOM;
	
	/* Initialisation of Ajax Page */
	public WishlistActivityPOM(TestSession session) throws Exception {
		super(session, "ElementLocators");
		wishlistActivityValidator= new WishlistActivityValidator(session);
		flipkartHomeScreenValidator = new FlipkartHomeScreenValidator(session);
		flipkartHomeScreenPOM = new FlipkartHomeScreenPOM(session);
	}

	public void clickOnSeachTextBox() {
		WebElement ele = element("search_textbox_element");
		waitForElementToBeClickable(ele, 25);
		element("search_textbox_element").click();
	}
	
	public void setDataToSeachTextBox(String text) {
		WebElement ele = element("search_textbox_element");
		waitForElementToBeClickable(ele, 25);
		element("search_textbox_element").sendKeys(text);
	}
	
	public void clickOnAutosuggestion() {
		WebElement ele = element("autosuggestion_element");
		waitForElementToBeClickable(ele, 25);
		element("autosuggestion_element").click();
	}
	
	public void clickOniphone13Product() {
		WebElement ele = element("iphone_13_element");
		waitForElementToBeClickable(ele, 25);
		element("iphone_13_element").click();
	}
	
	public void clickOnWishlistIcon() throws InterruptedException {
		WebElement ele = element("wishlist_icon_element");
		waitForElementToBeClickable(ele, 25);
		element("wishlist_icon_element").click();
		Thread.sleep(3000);
	}
	
	public void clickOnMyWishlistElement(){
		WebElement ele = element("my_wishlist_element");
		waitForElementToBeClickable(ele, 25);
		element("my_wishlist_element").click();
	}
	
	public void clickOnMyWishlistOption(){
		WebElement ele = element("wishlist_option_element");
		waitForElementToBeClickable(ele, 25);
		element("wishlist_option_element").click();
	}
	

	
	public void addProductTOWishlist(String product) throws InterruptedException {
		// Verify Product search textbox disppayed.
		flipkartHomeScreenValidator.verifyProductSearchButtonDisplayed();
	    //Click on the Product search textbox.
		flipkartHomeScreenPOM.clickOnProductSearchButton();
		//Verify Search textfiled displayed
	    wishlistActivityValidator.verifySearchTextBoxDisplayed();
	    //Click on the Seach textfied element
	    clickOnSeachTextBox();
	    //Enter text to the search textfield element.
	    setDataToSeachTextBox(product);
	    // Click on Autosuggestion
	    clickOnAutosuggestion();
	    //Click on the product
	    clickOniphone13Product();
	    //click on Wishlist icon
	    clickOnWishlistIcon();
	}
	
	public void goBackToHomePage() throws Exception {
		Thread.sleep(3000);
		//Swipe Bottom to Top
		ActionUtils.swipeBottomToTop(1, session.driver, 0.4, 0.8);
		
		//Click on PDP back button
		WebElement pdpBack = element("pdpBack_button_element");
		waitForElementToBeClickable(pdpBack, 25);
		element("pdpBack_button_element").click();
		
		//Click on PLP back button
		WebElement plpBack = element("pdpBack_button_element");
		waitForElementToBeClickable(plpBack, 25);
		element("pdpBack_button_element").click();
		
		//Click on cancel Search Button 
		WebElement cancelSearch = element("cancel_search_button");
		waitForElementToBeClickable(cancelSearch, 25);
		element("cancel_search_button").click();
	}
	
	
	public void goToMyWishlistPage() throws InterruptedException{
		//Click on Hamburger menu icon.
		flipkartHomeScreenPOM.clickOnHamburgerMenuButton();
		//Click on the Wishlist option
		clickOnMyWishlistOption();
		// Click on the My Wishlist Element
		clickOnMyWishlistElement();
		Thread.sleep(3000);
	}
	
	public void navigateBackToHomePage() throws InterruptedException {
		//Click on PDP back button
		WebElement pdpBack = element("pdpBack_button_element");
		waitForElementToBeClickable(pdpBack, 25);
		element("pdpBack_button_element").click();
		
		//Click on Wishlist & Collection back button
		WebElement wishBack = element("pdpBack_button_element");
		waitForElementToBeClickable(wishBack, 25);
		element("pdpBack_button_element").click();
		Thread.sleep(3000);
	}
}
