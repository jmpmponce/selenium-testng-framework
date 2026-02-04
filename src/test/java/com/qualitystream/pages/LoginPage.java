package com.qualitystream.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object que representa la página de Login. Contiene: - Locators -
 * Acciones del usuario - Navegación a la siguiente página
 */
public class LoginPage {

	// Driver recibido desde el test/base
	private final WebDriver driver;

	// Wait explícito reutilizable
	private final WebDriverWait wait;

	// Locators de la página de login
	private final By username = By.id("user-name");
	private final By password = By.id("password");
	private final By loginBtn = By.id("login-button");

	/**
	 * Constructor del Page Object Recibe el driver y el wait desde el test
	 */
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	/**
	 * Espera a que la página de login esté cargada Se usa para asegurar estabilidad
	 * del test
	 */
	public LoginPage waitUntilLoaded() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		return this;
	}

	/**
	 * Realiza login con usuario y contraseña
	 * 
	 * @param user usuario
	 * @param pass contraseña
	 * @return InventoryPage (navegación a otra página)
	 */
	public InventoryPage loginAs(String user, String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();

		// Al hacer login, se navega a InventoryPage
		return new InventoryPage(driver, wait);
	}
}
