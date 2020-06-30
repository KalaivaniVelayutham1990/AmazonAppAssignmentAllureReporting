package testScripts;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import utilities.Generics;

public class BaseTest {

	public String browserPath_mac = System.getProperty("user.dir") + File.separator + "drivers" + File.separator
			+ "chromedriver";
	public String browserPath_win = System.getProperty("user.dir") + File.separator + "drivers" + File.separator
			+ "chromedriver.exe";

	public WebDriver driver;

	@BeforeClass
	@Step("Launch Amazon App in chrome")
	@Severity(SeverityLevel.BLOCKER)
	public void launchApp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(MobileCapabilityType.NO_RESET, false);
		dc.setCapability(MobileCapabilityType.VERSION, Generics.getValueFromConfigFile("platformVersion"));
		dc.setCapability("deviceName", Generics.getValueFromConfigFile("deviceName"));
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		dc.setCapability("browserName", Generics.getValueFromConfigFile("browser"));
		dc.setCapability("chromedriverExecutable", browserPath_win);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

	}

	@AfterClass
	public void tearDown() throws IOException {
		driver.quit();
	}

}
