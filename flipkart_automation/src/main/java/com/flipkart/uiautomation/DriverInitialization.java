package com.flipkart.uiautomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverInitialization {

	public static MobileDriver<WebElement> driver;

	public MobileDriver<WebElement> getDriver(Map<String, Object> config) {

		String projectPath = System.getProperty("user.dir");
		String platformName = (String) config.get("platform");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (platformName.toLowerCase()) {

		case "android":
			Map<String, Object> androidConfig = (Map<String, Object>) config.get("android");
			capabilities.setCapability("appPackage", androidConfig.get("appPackage"));
			capabilities.setCapability("appWaitPackage", androidConfig.get("appPackage"));
			capabilities.setCapability("appActivity", androidConfig.get("appActivity"));
			capabilities.setCapability("appWaitActivity", androidConfig.get("appActivity"));
			capabilities.setCapability("platformName", platformName.toLowerCase());
			capabilities.setCapability("deviceName", androidConfig.get("deviceName"));
			capabilities.setCapability(MobileCapabilityType.UDID, androidConfig.get("udid"));
			capabilities.setCapability("platformVersion", androidConfig.get("platformVersion"));
			capabilities.setCapability("shouldUseCompactResponses", false);
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
			capabilities.setCapability("app", projectPath + "" + "/App/" + androidConfig.get("app"));
			capabilities.setCapability("automationName", "UiAutomator2");
			capabilities.setCapability("disableWindowAnimation", true);
			capabilities.setCapability("newCommandTimeout", 120);
			capabilities.setCapability("waitForIdleTimeout", 2000);

			try {
				driver = new AndroidDriver<>(new URL((String) androidConfig.get("server")), capabilities);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		case "ios":
			Map<String, Object> iosconfig = (Map<String, Object>) config.get("ios");
			capabilities.setCapability("automationName", iosconfig.get("automationName"));
			capabilities.setCapability("deviceName", iosconfig.get("deviceName"));
			capabilities.setCapability("platformName", platformName.toLowerCase());
			capabilities.setCapability("platformVersion", iosconfig.get("platformVersion"));
			capabilities.setCapability("bundleId", iosconfig.get("bundleId"));
			capabilities.setCapability("udid", iosconfig.get("udid"));
			capabilities.setCapability("noReset", true);
			capabilities.setCapability("waitForQuiescence", false);
			capabilities.setCapability("wdaEventloopIdleDelay", 3);
			capabilities.setCapability("eventLoopIdleDelaySec", 1);
			capabilities.setCapability("useJSONSource", true);
			capabilities.setCapability("useNewWDA", true);
			capabilities.setCapability("fullReset", false);
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("disableWindowAnimation", true);

			try {
				driver = new IOSDriver<>(new URL((String) iosconfig.get("server")), capabilities);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return driver;
	}

}