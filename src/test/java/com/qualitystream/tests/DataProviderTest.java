package com.qualitystream.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qualitystream.base.BaseTest;
import com.qualitystream.data.DataProviders;
import com.qualitystream.pages.InventoryPage;
import com.qualitystream.pages.LoginPage;

public class DataProviderTest extends BaseTest {
	/**
	 * Test con usuarios válidos. Este método se ejecutará UNA VEZ por cada fila del
	 * DataProvider "validUsers".
	 */
	@Test(groups = { "regression" }, dataProvider = "validUsers", dataProviderClass = DataProviders.class)
	public void loginWithValidUsers_shouldEnterInventory(String user, String pass) {

		InventoryPage inventory = new LoginPage(driver, wait).waitUntilLoaded().loginAs(user, pass).waitUntilLoaded();

		// Validamos que entramos al inventario
		Assert.assertTrue(inventory != null, "No se pudo entrar al inventario con el usuario: " + user);
	}

	/**
	 * Test con usuarios inválidos o bloqueados. Este test también se ejecuta una
	 * vez por cada fila del DataProvider "invalidUsers".
	 */
	@Test(groups = { "regression" }, dataProvider = "invalidUsers", dataProviderClass = DataProviders.class)
	public void loginWithInvalidUsers_shouldStayOnLogin(String user, String pass) {

		new LoginPage(driver, wait).waitUntilLoaded().loginAs(user, pass);

		// Validamos que seguimos en la página de login (no entró al inventario)
		Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"),
				"El usuario inválido NO debería poder entrar: " + user);
	}

}
