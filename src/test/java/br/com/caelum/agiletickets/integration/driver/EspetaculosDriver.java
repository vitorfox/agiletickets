package br.com.caelum.agiletickets.integration.driver;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EspetaculosDriver {

	private static final String BASE_URL = "http://localhost:8080";
	private final WebDriver driver;

	public EspetaculosDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void abreListagem() {
		driver.get(BASE_URL + "/espetaculos");
	}

	public void adicioneEspetaculo(String nome, String descricao, String tipo, String local) {
		WebElement form = form();
		form.findElement(By.name("espetaculo.nome")).sendKeys(nome);
		form.findElement(By.name("espetaculo.descricao")).sendKeys(descricao);
		form.findElement(By.name("espetaculo.tipo")).sendKeys(tipo);
		form.findElement(By.name("espetaculo.estabelecimento.id")).sendKeys(local);
		form.submit();
	}

	public void ultimaLinhaDeveConter(String nome, String endereco) {
		WebElement ultimaLinha = ultimaLinha();
		assertThat(ultimaLinha.findElements(By.tagName("td")).get(1).getText(), is(nome));
		assertThat(ultimaLinha.findElements(By.tagName("td")).get(2).getText(), is(endereco));
	}

	public void deveMostrarErro(String erro) {
		WebElement erros = driver.findElement(By.id("errors"));

		assertThat(erros.getText(), containsString(erro));
	}

	private WebElement form() {
		return driver.findElement(By.id("addForm"));
	}

	private WebElement ultimaLinha() {
		List<WebElement> linhas = driver.findElements(By.tagName("tr"));
		WebElement ultimaLinha = linhas.get(linhas.size() - 1);
		return ultimaLinha;
	}

}
