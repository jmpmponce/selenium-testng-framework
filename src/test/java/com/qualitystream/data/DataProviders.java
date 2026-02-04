package com.qualitystream.data;

import org.testng.annotations.DataProvider;

public class DataProviders {

	/**
	 * Usuarios válidos y problemáticos
	 */
	@DataProvider(name = "validUsers")
	public Object[][] validUsers() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "problem_user", "secret_sauce" },
				{ "performance_glitch_user", "secret_sauce" } };
	}

	/**
	 * Usuarios inválidos / bloqueados
	 */
	@DataProvider(name = "invalidUsers")
	public Object[][] invalidUsers() {
		return new Object[][] { { "locked_out_user", "secret_sauce" }, { "standard_user", "wrong_pass" } };
	}
}
