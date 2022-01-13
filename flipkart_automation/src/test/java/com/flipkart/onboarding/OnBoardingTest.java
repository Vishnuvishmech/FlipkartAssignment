/**
 * @author Vishnu
 * @data
 */
package com.flipkart.onboarding;

import org.testng.annotations.Test;

import com.flipkart.base.Setup;
import com.flipkart.uiautomation.TestSession;
import com.relevantcodes.extentreports.ExtentTest;

public class OnBoardingTest extends Setup {


	@Test(testName = "FlipkartAppOnboarding", description = "Onboard User to Flipkart app Test", alwaysRun = true)
	public void FlipkartAppOnboarding() throws Exception {
		
		//Perform onboarding activity to Flipkart App
		onboardingFlipkartAppPOM.PerformOnboarding((String)TestSession.creds.get("email"),(String)TestSession.creds.get("password"));		
		
		// Verify Flipkart home screen is displayed.
		flipkartHomeScreenValidator.verifyHomeScreenDisplayed();

	}


	@Test(testName = "WishListActivityTest", description = "Verifies wishlist functionality of Flipkart app ", dependsOnMethods= "FlipkartAppOnboarding", alwaysRun = true)
	public void WishListActivityTest() throws Exception {

	    // Verify Flipkart home screen is displayed.
	    flipkartHomeScreenValidator.verifyHomeScreenDisplayed();
	    
	    wishlistActivityPOM.addProductTOWishlist("iphone 13 Pro max");
	    
	    // Go Back to Home Page
	    wishlistActivityPOM.goBackToHomePage();
	    
	    //Click on My Wishlist 
	    wishlistActivityPOM.goToMyWishlistPage();
	    
	    //Navigate Back to HomeScreen
	    wishlistActivityPOM.navigateBackToHomePage();
	}
	
}
