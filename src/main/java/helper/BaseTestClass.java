package com.learning.helper;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass extends STRINGS {
	
	protected WebDriver driver;
	protected WebDriver decorateDriver;
	protected DevTools devTools;
	
	@BeforeEach
	void setup() {
		
//		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		MyWebDriverListner listner = new MyWebDriverListner(driver);
		decorateDriver = new EventFiringDecorator<WebDriver>(listner).decorate(driver);
		if (driver instanceof ChromeDriver) {
			devTools = ((HasDevTools) driver).getDevTools();
			devTools.createSession();
		}
	}
	
	@AfterEach
	void tearDown() {
		if(driver != null)
			driver.quit();
		if(devTools != null)
			devTools.close();
	}
	
}
