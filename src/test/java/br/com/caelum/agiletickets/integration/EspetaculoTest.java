package br.com.caelum.agiletickets.integration;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.caelum.agiletickets.integration.driver.EspetaculosDriver;

public class EspetaculoTest {

	public static String BASE_URL = "http://localhost:8080";
	private static WebDriver browser;
	private EspetaculosDriver espetaculos;

	@BeforeClass
	public static void abreBrowser() {
		browser = new FirefoxDriver();
	}

	@Before
	public void setUp() throws Exception {
		espetaculos = new EspetaculosDriver(browser);
	}

	@AfterClass
	public static void teardown() {
		browser.close();
	}
	
	@Test
	public void deveAdicionarEspetaculoComTodosOsParametros() throws Exception {
		espetaculos.adicioneEspetaculo("Maior show do seculo - Show do Legiao Urbana!", "Vai ser um show muito foda!!", "SHOW", "15");
	}
	
}
