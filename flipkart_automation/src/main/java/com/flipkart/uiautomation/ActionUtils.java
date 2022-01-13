package com.flipkart.uiautomation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.WordUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.asprise.ocr.Ocr;
import com.flipkart.app.automation.helpers.OnboardingFlipkartAppPOM;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class ActionUtils{
	/**
	 * @description: Method to convert String input to title case
	 * @param text
	 * @return
	 */
	public static String titleCase(String text) {
		final char[] delimiters = { ' ', '_' };
		return WordUtils.capitalizeFully(text, delimiters);
	}

	/**
	 * 
	 * Description: This method to scroll left side based on device height and width
	 * 
	 * @param value
	 * @param startX
	 * @param endX
	 * @param driver
	 * @throws Exception
	 */

	public static void swipeRightToLeft(int value, double startX, double endX, MobileDriver driver) throws Exception {
		try {
			Thread.sleep(1000);
			System.out.println("Swiping Left");
			for (int i = 1; i <= value; i++) {

				Dimension dSize = driver.manage().window().getSize();

				int startx = (int) (dSize.width * startX);
				int endx = (int) (dSize.width * endX);
				int starty = dSize.height / 3;
				driver.swipe(startx, starty, endx, starty, 1000);
			}
		} catch (Exception e) {

			throw e;
		}
	}

	/**
	 * Description: Method to perform left swipe w.r.t Element position
	 * 
	 * @param webelement
	 * @param timeduration
	 * @param startX
	 * @param endX
	 * @param driver
	 */
	public static void swipeElementToRight(WebElement ele, double startX, double endX, MobileDriver driver) {
		try {
			Dimension size = driver.manage().window().getSize();
			int startx = (int) (size.width * startX);
			int endx = (int) (size.width * endX);
			int starty = ele.getLocation().getY();
			driver.swipe(startx, starty, endx, starty, 1000);
			System.out.println("Swiping Right");
		} catch (Exception e) {
			System.out.println("Unable to Swipe..!");
		}

	}

	/**
	 * Description: Method to perform right swipe w.r.t Element position
	 * 
	 * @param webelement
	 * @param timeduration
	 * @param startX
	 * @param endX
	 * @param driver
	 */
	public static void swipeElementToLeft(WebElement ele, double startX, double endX, MobileDriver driver) {
		try {
			Dimension size = driver.manage().window().getSize();
			int startx = (int) (size.width * startX);
			int endx = (int) (size.width * endX);
			int starty = ele.getLocation().getY();
			driver.swipe(startx, starty, endx, starty, 1000);
			System.out.println("Swiping Left");
		} catch (Exception e) {
			System.out.println("Unable to Swipe..!");
		}

	}

	/**
	 * Description: This method to scroll Right side based on device height and
	 * width
	 * 
	 * @param value
	 * @param startx
	 * @param endx
	 * @param driver
	 * @throws Exception
	 */
	public static void swipeLefToRight(int value, double startx, double endx, MobileDriver driver) throws Exception {
		try {
			Thread.sleep(1000);

			System.out.println("Swiping Right");

			for (int i = 1; i <= value; i++) {

				Dimension dSize = driver.manage().window().getSize();
				int startX = (int) (dSize.width * startx);
				int endX = (int) (dSize.width * endx);
				int starty = dSize.height / 2;
				driver.swipe(startX, starty, endX, starty, 1000);
			}
		} catch (Exception e) {

			throw e;

		}
	}

	/**
	 * Description: This method to scroll Up side based on device height and width
	 * @param value
	 * @param driver
	 * @param starty1
	 * @param endy1
	 * @throws Exception
	 */

	public static void swipeBottomToTop(int value, MobileDriver driver, double starty1, double endy1) throws Exception {
		try {
			Thread.sleep(1000);

			System.out.println("Swiping Up");

			for (int i = 1; i <= value; i++) {

				Dimension dSize = driver.manage().window().getSize();
				int starty = (int) (dSize.height * starty1);
				int endy = ((int) (dSize.height * endy1));
				int startx = dSize.width / 2;
				driver.swipe(startx, starty, startx, endy, 1000);
			}
		} catch (Exception e) {

			throw e;
		}
	}

	/**
	 * Description: This method to scroll Bottom side based on device height and width
	 * @param value
	 * @param driver
	 * @param starty1
	 * @param endy1
	 * @throws Exception
	 */
	public static void swipeTopToBottom(int value, MobileDriver driver, double starty1, double endy1) throws Exception {
		try {
			Thread.sleep(1000);
			for (int i = 1; i <= value; i++) {

				Dimension dSize = driver.manage().window().getSize();
				int starty = (int) (dSize.height * starty1);
				int endy = (int) (dSize.height * endy1);
				int startx = dSize.width / 2;
				driver.swipe(startx, starty, startx, endy, 1000);
			}
		} catch (Exception e) {

			throw e;
		}
	}

	/**
	 * @description Tap on particular element based size co-orinates
	 * @param x
	 * @param y
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void tapByCoordinates(double x, double y, MobileDriver driver) throws InterruptedException {
		TouchAction action = new TouchAction(driver);
		Dimension dSize = driver.manage().window().getSize();
		int sX = (int) (dSize.width * x);
		int sY = (int) (dSize.height * y);
		action.tap(sX, sY).perform();
		System.out.println("Tapped");
	}

	/**
	 * 
	 * Description: Method for Scrolling to particular element based on direction and device size
	 * @param maxScroll
	 * @param start
	 * @param end
	 * @param scrollType
	 * @param element
	 * @param driver
	 * @throws Exception
	 */
	public static void scrollToElement(int maxScroll, double start, double end, String scrollType,WebElement element,
			MobileDriver driver) throws Exception {

		while (maxScroll != 0) {
			try {
				System.out.println("Trying to locate the element");
				if (element.isDisplayed()) {
					maxScroll++;
					break;
				}
			}
				catch (NoSuchElementException e) {
					switch (scrollType.toUpperCase()) {
					case ("DOWN"):
						swipeTopToBottom(1, driver, start, end);
						break;

					case ("UP"):

						swipeBottomToTop(1, driver, start, end);
						break;

					case ("LEFT"):
						swipeRightToLeft(1, start, end, driver);
						break;

					case ("RIGHT"):
						swipeLefToRight(1, start, end, driver);
						break;

					default:

						break;

					}
			} catch (Exception e) {
				switch (scrollType.toUpperCase()) {
				case ("DOWN"):
					swipeTopToBottom(1, driver, start, end);
					break;

				case ("UP"):

					swipeBottomToTop(1, driver, start, end);
					break;

				case ("LEFT"):
					swipeRightToLeft(1, start, end, driver);
					break;

				case ("RIGHT"):
					swipeLefToRight(1, start, end, driver);
					break;

				default:

					break;

				}
				
				
				
			}
			maxScroll--;
		}
	}

	/**
	 * @description Method to check whether and specific word present in image using
	 *              Ocr
	 * @param path
	 */
	public static void checkUsingOcr(String path) {
		Ocr.setUp();
		Ocr ocr = new Ocr();
		ocr.startEngine("eng", Ocr.SPEED_FASTEST);
		String s = ocr.recognize(new File[] { new File(path) }, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
		String[] stringarr = s.split("/n");
		for (String arr : stringarr) {
			if (arr.contains("error") || arr.contains("snap") || arr.contains("Oops") || arr.contains("Something went wrong") || arr.contains("Unable to connect to server")|| arr.isEmpty()
					|| arr.contains("Webpage not available")) {
				System.out.println("--> Page has not been loaded or loaded with error ");
			} else {
				System.out.println("--> Page has been loaded without errors");
			}
		}

		ocr.stopEngine();
	}

	/**
	 * @description Method to take screenshot
	 * @param driver
	 * @return path
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static String takeScreenshot(MobileDriver driver, int timeout) throws IOException, InterruptedException {
		Thread.sleep(timeout);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "Screenshot" + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(src, destination);
		return dest;
	}

	/**
	 * @description Method to perform mouse click on a webelement
	 * @param driver
	 * @param element
	 */
	public static void mouseClick(MobileDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void tapOnElement(MobileDriver driver, WebElement element) {
		try {
			TouchAction action = new TouchAction(driver);
			action.tap(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description Tap on particular element based size co-orinates
	 * @param x
	 * @param y
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void tapOnElement(double x, double y, MobileDriver driver) throws InterruptedException {

		Dimension dSize = driver.manage().window().getSize();
		int sX = (int) (dSize.width * x);
		int sY = (int) (dSize.height * y);
		driver.tap(1, sX, sY, 1);
		System.out.println("Tapped");
	}

	/**
	 * @param path
	 * @param driver
	 * @return
	 * @throws IOException
	 */
	public static String captureScreenshot(String path, MobileDriver<WebElement> driver) throws IOException {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String sDate = sdf.format(date);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = path + "/" + sDate + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(src, destination);
		return dest;

	}


	public static void swipeWithElement(MobileDriver driver, WebElement element, double start, double end) {

		Dimension size = driver.manage().window().getSize();
		int startY = element.getLocation().getY();
		int startX = (int) (size.width * start);
		int endX = (int) (size.width * end);
		new TouchAction(driver).press(startX, startY).waitAction(500).moveTo(endX, startY).release().perform();
	}

	/**
	 * @description Method to swipe left or right
	 * @param driver
	 * @param start
	 * @param end
	 */
	public static void swipe(MobileDriver driver, double start, double end) {

		Dimension size = driver.manage().window().getSize();
		int y = size.height / 2;
		int startX = (int) (size.width * start);
		int endX = (int) (size.width * end);
		new TouchAction(driver).press(startX, y).waitAction(1000).moveTo(endX, y).release().perform();

	}

	/**
	 * @description Method to scroll up or down
	 * @param driver
	 * @param start
	 * @param end
	 */
	public static void scroll(MobileDriver driver, double start, double end) {

		Dimension size = driver.manage().window().getSize();

		int x = size.width / 2;
		int startY = (int) (size.height * start);
		int endY = (int) (size.height * end);
		new TouchAction(driver).press(x, startY).waitAction(1000).moveTo(x, endY).release().perform();

	}

	/**
	 * @description Method to scroll up or down
	 * @param driver
	 * @param start
	 * @param end
	 */
	public static void scrollwithElement(WebElement element, MobileDriver driver, double start, double end) {

		Dimension size = driver.manage().window().getSize();

		int startX = element.getLocation().getX();
		int startY = (int) (size.height * start);
		int endY = (int) (size.height * end);
		new TouchAction(driver).press(startX, startY).waitAction(1000).moveTo(startX, endY).release().perform();

	}

	/**
	 * @dscription - Method to get current date and time
	 * @return - String (returns date and time)
	 */
	public static String getCurrentDateTime() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy:HH.mm.ss");
		return formatter.format(currentDate.getTime());
	}

	/**
	 * @description Method to check whether and specific word present in image using
	 *              Ocr
	 * @param path
	 * @param title
	 */
	public static boolean checkUsingOcrWithReturn(String path, String title) {
		boolean titlePresent = false;
		Ocr.setUp();
		Ocr ocr = new Ocr();
		ocr.startEngine("eng", Ocr.SPEED_FASTEST);
		String s = ocr.recognize(new File[] { new File(path) }, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
		String[] stringarr = s.split("/n");
		for (String arr : stringarr) {
			if (arr.contains(title)) {
				titlePresent = true;
			} else {
				titlePresent = false;
			}
		}
		ocr.stopEngine();
		return titlePresent;
	}

	/**
	 * @description Method to check whether and specific word present in imaage
	 *              using Ocr
	 * @param path
	 */
	public static void checkUsingOcr(String path, String title) {
		Ocr.setUp();
		Ocr ocr = new Ocr();
		ocr.startEngine("eng", Ocr.SPEED_FASTEST);
		String s = ocr.recognize(new File[] { new File(path) }, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
		String[] stringarr = s.split("/n");
		for (String arr : stringarr) {
			if (arr.contains(title)) {
				System.out.println("\n\nresult is " + title);
			} else {
				System.out.println("\n\n" + title + " title not verified");
			}
		}
		ocr.stopEngine();
	}

	/**
	 * @description Method to check whether for alert and if present,accept it
	 * @param driver
	 */
	public static void chkAlertPresentAndAccept(MobileDriver<WebElement> driver) {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println(" --> " + e.getMessage());
		}
	}

	/**
	 * @description Method to check whether for alert and if present,accept it
	 * @param driver
	 */
	public static void chkAlertPresentAndDismiss(MobileDriver<WebElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
			driver.switchTo().alert().dismiss();
		} else {
			System.out.println("--> Alert was not displayed");
		}
	}
	
}
