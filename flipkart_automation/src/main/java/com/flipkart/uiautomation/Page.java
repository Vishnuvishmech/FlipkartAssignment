package com.flipkart.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Page {

	public TestSession session;
	public YamlPage pageUI;
	public String pageYamlFile;
	public Boolean hasContext;
	private WebDriverWait wait;

	public Page(TestSession session, String pageYamlFile) throws Exception {
		this.session = session;
		this.pageYamlFile = pageYamlFile;
		this.pageUI = new YamlPage(session.config.get("platform").toString(),
				session.config.get("page_spec_file_root").toString(), pageYamlFile);
		this.hasContext = false;
		if (pageUI.context != null) {
			this.hasContext = true;
		}
	}

	public WebElement element(String name) {
		YamlElement yamlElement = pageUI.element(name);
		WebElement ele = findElement(yamlElement);
		System.out.println("Found element ->" + name);
		return ele;
	}

	public List<WebElement> elements(String name) {
		YamlElement yamlElement = pageUI.element(name);
		return findElements(yamlElement);
	}

	protected WebElement findElement(YamlElement yamlElement) {
		return session.driver.findElement(findBy(yamlElement));
	}

	private List<WebElement> findElements(YamlElement yamlElement) {
		return session.driver.findElements(findBy(yamlElement));
	}

	public By findBy(YamlElement yamlElement) {
		switch (yamlElement.findBy) {
		case ("id"):
			return By.id(yamlElement.locator);
		case ("name"):
			return By.name(yamlElement.locator);
		case ("css"):
			return By.cssSelector(yamlElement.locator);
		case ("cssSelector"):
			return By.cssSelector(yamlElement.locator);
		case ("linkText"):
			return By.linkText(yamlElement.locator);
		case ("partialLinkText"):
			return By.partialLinkText(yamlElement.locator);
		case ("xpath"):
			return By.xpath(yamlElement.locator);
		case ("class"):
			return By.className(yamlElement.locator);
		case ("className"):
			return By.className(yamlElement.locator);
		}
		return By.cssSelector(yamlElement.locator);
	}


	public By findBy(String elementName) {
		YamlElement yamlElement = pageUI.element(elementName);
		return findBy(yamlElement);
	}

	public Boolean hasExpectedTitle() {
		return session.driver.getTitle().equals(pageUI.expectedTitle);
	}


	public Boolean isDisplayed() throws Exception {
		System.out.println("#isDisplayed()?");
		for (YamlElement yamlElement : pageUI.expectedElements()) {
			System.out.println("checking expectedElement : " + yamlElement);
			if (!findElement(yamlElement).isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	
	public void waitForElementToBeClickable(WebElement el, Integer timeout) {
		wait = new WebDriverWait(session.driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}


	/* Method to handle explicit wait for dynamic WebElement */
	public WebElement mobileElement(String locator) {
		return session.driver.findElement(By.xpath(locator));
	}
	
	

	public void resettingImplicitWait(Integer timeout) {
		session.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

}
