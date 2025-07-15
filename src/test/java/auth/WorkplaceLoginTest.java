package com.learning.bookprograms.ch5browserSpecificManipulation;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.learning.helper.BaseTestClass;
import com.learning.helper.PropertiesReader;
import com.learning.helper.TOTPGenerator;

class WorkplaceLoginTest extends BaseTestClass {

	@Test
	void workplaceLoginTest() throws InterruptedException {
		String secretKey = PropertiesReader.getWpProp("secretKey");
		String url = PropertiesReader.getWpProp("wp_url");
		String email = PropertiesReader.getWpProp("email");
		String password = PropertiesReader.getWpProp("password");
		
		By mainPageEmailInput = By.cssSelector("input[data-testid='email_input']");
		By emailDialogInput = By.cssSelector("input[type='email']");
		By mainNextButton = By.cssSelector("button[data-testid='next_button']");
		By emailNextButton = By.cssSelector("input[value='Next']");
		By pwdDialogInput = By.cssSelector("input[type='password']");
		By pwdSignInButton = By.cssSelector("input[value='Sign in']");
		By useCodeButton = By.xpath("//div[text()='Use a verification code']");
		By totpInput = By.cssSelector("input[name='otc']");
		By submitTOTPButton = By.cssSelector("#idSubmit_SAOTCC_Continue");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get(url);
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageEmailInput));
		driver.findElement(mainPageEmailInput).sendKeys(email);;
		Thread.sleep(3000);
		driver.findElement(mainNextButton).click();
//		Thread.sleep(6000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailDialogInput));
		driver.findElement(emailDialogInput).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(emailNextButton).click();;
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(pwdDialogInput));
		driver.findElement(pwdDialogInput).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(pwdSignInButton).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(useCodeButton));
		Thread.sleep(2000);
		driver.findElement(useCodeButton).click();
		
		
		String totpString = TOTPGenerator.getTotp(secretKey);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(totpInput));
		Thread.sleep(2000);
		driver.findElement(totpInput).sendKeys(totpString);
		Thread.sleep(2000);
		
		driver.findElement(submitTOTPButton).click();
		
		Thread.sleep(50000);
	}

}
