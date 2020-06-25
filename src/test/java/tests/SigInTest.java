package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SigInTest {

	private static void sleep(final int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void criarConta() {
		//setar um nome aleatório
		String nome = "Skaffold";
		
		// Seta as propriedades do Driver, passando como parâmetro o Driver e o local
		// onde está armazenado;
		System.setProperty("webdriver.chrome.driver", "/home/arthur/Downloads/chromedriver");

		// Abre o navegador;
		WebDriver navegador = new ChromeDriver();

		// Fala para o navegador abrir o site;
		navegador.get("http://www.juliodelima.com.br/taskit");

		// O método sleep fala para o Selenium esperar pelos segundos passados pelo
		// parâmetro
		// antes de executar outra parte do código, para ficar mais visível e didático;
		sleep(3);

		// Encontra o botão para criar uma nova conta e armazena ele em uma variável
		// para podermos fazer alguma ação em cima dele;

		WebElement sigIn = navegador.findElement(By.xpath("//a[contains(text(), 'Ok, I wanna sign up now')]"));

		// Clica no botão para criar uma conta (OK, I WANNA SIGN UP NOW)
		sigIn.click();

		// Encontra o elemento para escrever o nome, e armazena em uma variável
		WebElement name = navegador.findElement(By.xpath("//input[@name=\"name\"]"));

		// Clica no elemento e escreve o nome
		sleep(3);
		name.click();
		name.sendKeys(nome);
		sleep(3);

		// Encontra o elemento para escrever o login, e armazena dentro de uma variável
		// (não precisa necessáriamente armazenar em uma variável, só estamos
		// armazenando
		// para sermos mais didáticos)

		// Encontra o elemento para escrever o login, e armazena em uma variável
		WebElement login = navegador.findElement(By.xpath("//input[@name=\"login\"]"));

		// Clica no elemento e escreve o login e simula o clique no botão TAB
		login.click();
		login.sendKeys(nome + Keys.TAB);
		sleep(3);

		// Encontra o elemento para escrever o senha, e armazena em uma variável
		WebElement senha = navegador.findElement(By.xpath("//input[@name=\"password\"]"));

		// Clica no elemento e escreve a senha;
		senha.click();
		senha.sendKeys("qualquer");
		sleep(3);

		// Encontra o botão salvar e clica nele;
		// (Não armazenando em nenhuma variável para provar que não precisa.)
		navegador.findElement(By.xpath("//a[contains(text(), \"Save\")]")).click();

		sleep(5);
		WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();

        assertEquals("Hi, " + nome, textoNoElementoMe);
        navegador.quit();
	}
	
	

}
