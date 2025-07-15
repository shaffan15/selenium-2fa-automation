package auth;

import java.time.Duration;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.virtualauthenticator.HasVirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions;

import helper.BaseTestClass;

class TestWebAuthn extends BaseTestClass {

	@Test
	void testWebAuthn() {
		driver.get("https://webauthn.io/");
		HasVirtualAuthenticator virtualAuthenticator = (HasVirtualAuthenticator) driver;
		VirtualAuthenticator authenticator = virtualAuthenticator.addVirtualAuthenticator(new VirtualAuthenticatorOptions());
		String randomId = UUID.randomUUID().toString();
		driver.findElement(By.id("input-email")).sendKeys(randomId);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.id("register-button")).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[x-text='alert.text']"), "Success! Now try to authenticate..."));
		driver.findElement(By.id("login-button")).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[@href='/logout']"), "Try it again?"));
		virtualAuthenticator.removeVirtualAuthenticator(authenticator);
	}

}
