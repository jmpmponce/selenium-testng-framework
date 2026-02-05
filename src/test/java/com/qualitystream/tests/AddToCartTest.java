package com.qualitystream.tests;

import org.testng.Assert;
import com.qualitystream.utils.ConfigManager;
import org.testng.annotations.Test;

import com.qualitystream.base.BaseTest;
import com.qualitystream.pages.InventoryPage;
import com.qualitystream.pages.LoginPage;

/**
 * Test de negocio: Login exitoso + agregar producto al carrito
 */
public class AddToCartTest extends BaseTest {

	/**
	 * Escenario: 1. Usuario hace login 2. Agrega un producto 3. Se valida que el
	 * carrito tenga 1 ítem
	 */
	@Test(groups = { "smoke", "regression" })
	public void addBackpackToCart_shouldShowBadge1() {

		// Flujo completo usando Page Object y chaining
		InventoryPage inventory = new LoginPage(driver, wait).waitUntilLoaded()
				.loginAs(ConfigManager.get("user.standard"), ConfigManager.get("user.password")).waitUntilLoaded()
				.addBackpackToCart();

		// Validación del resultado esperado
		Assert.assertEquals(inventory.getCartBadgeCount(), "1", "El carrito no quedó con 1 ítem");
	}
}
