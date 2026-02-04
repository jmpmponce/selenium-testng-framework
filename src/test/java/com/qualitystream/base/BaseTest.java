package com.qualitystream.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Clase base para TODOS los tests. Aquí se maneja el ciclo de vida del
 * WebDriver: - Inicialización del navegador - Configuración de waits - Cierre
 * del navegador
 *
 * Los tests NO deberían preocuparse de esto.
 */
public class BaseTest {

	// WebDriver compartido por los tests que extienden esta clase
	protected WebDriver driver;

	// Wait explícito reutilizable
	protected WebDriverWait wait;

	/**
	 * Se ejecuta ANTES de cada @Test Prepara el entorno de prueba
	 */
	@BeforeMethod
	public void setup() {
		// Descarga y configura automáticamente el driver de Chrome
		WebDriverManager.chromedriver().setup();

		// Inicializa el navegador
		driver = new ChromeDriver();

		// Maximiza la ventana del navegador
		driver.manage().window().maximize();

		// Inicializa el wait explícito (hasta 10 segundos)
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Navega a la URL base de la aplicación
		driver.get("https://www.saucedemo.com/");
	}

	/**
	 * Se ejecuta DESPUÉS de cada @Test Libera recursos cerrando el navegador
	 */
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
