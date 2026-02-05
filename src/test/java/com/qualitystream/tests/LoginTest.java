package com.qualitystream.tests;

import java.time.Duration;

import com.qualitystream.base.BaseTest;
import com.qualitystream.utils.ConfigManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest {

	@Test(groups = { "smoke", "regression" })
	public void loginValido() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

		driver.findElement(By.id("user-name")).sendKeys(ConfigManager.get("user.standard"));

		driver.findElement(By.id("password")).sendKeys(ConfigManager.get("user.password"));
		driver.findElement(By.id("login-button")).click();

		wait.until(ExpectedConditions.urlContains("inventory.html"));

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
				"No se ingresó correctamente al inventario");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
