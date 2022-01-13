package com.flipkart.uiautomation;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.yaml.snakeyaml.Yaml;

import io.appium.java_client.MobileDriver;

public class TestSession {

	public MobileDriver<WebElement> driver;
	public Map<String, Object> config;
	public static Map<String, Object> creds;
	public TestSession() {
		config = (Map<String, Object>) new Yaml()
				.load(getClass().getClassLoader().getResourceAsStream("configuration.yaml"));
		driver =  new DriverInitialization().getDriver(config);
		creds=config;
	}

}
