package com.qualitystream.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object que representa la página de inventario (productos). Aquí se
 * modelan acciones del negocio como: - Agregar productos al carrito - Leer el
 * estado del carrito
 */
public class InventoryPage {

	// Driver compartido
	private final WebDriver driver;

	// Wait explícito
	private final WebDriverWait wait;

	// Elementos de la página
	private final By title = By.className("title");
	private final By addBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");
	private final By cartBadge = By.className("shopping_cart_badge");

	/**
	 * Constructor del InventoryPage
	 */
	public InventoryPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	/**
	 * Espera a que la página de inventario esté cargada
	 */
	public InventoryPage waitUntilLoaded() {
		wait.until(ExpectedConditions.urlContains("inventory.html"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(title));
		return this;
	}

	/**
	 * Agrega el producto Backpack al carrito
	 */
	public InventoryPage addBackpackToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addBackpackBtn)).click();
		return this;
	}

	/**
	 * Obtiene el número mostrado en el badge del carrito
	 * 
	 * @return cantidad de productos en el carrito
	 */
	public String getCartBadgeCount() {
		if (driver.findElements(cartBadge).isEmpty()) {
			return "0";
		}
		return driver.findElement(cartBadge).getText().trim();
	}
}
