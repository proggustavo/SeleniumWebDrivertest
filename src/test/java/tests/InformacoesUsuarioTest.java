package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {

    @Test

    public void testAdicionarUmaInformacaoDoUsuario(){


        // Abrindo o navegador
        System.setProperty("webDriver.chrome.driver", "/usr/local/lib/node_modules/chromedriver/lib/chromedriver/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        navegador.manage().window().maximize();

        //Navegando para a página

        navegador.get("http://www.juliodelima.com.br/taskit");

        //Clicar no link que possui o texto Sign in
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificando o formulário de login

        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Clicar no campo com name 'login' que está dentro do formulário id = "signinbox"
        // Digitar o login julio0001

        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        //Clicar no campo com name 'passsword' que está dentro do formulário id = "signinbox"

        //Digitar o password = "123456"

        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto "SIGN IN"

        navegador.findElement(By.linkText("SIGN IN")).click();

        //Validar que dentro do elemento com class "me" está o texto "Hi, Julio"

        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();


        assertEquals("Hi, Julio", textoNoElementoMe);

        System.out.println(textoNoElementoMe);

        //Fechar o Navegador navegador.quit fecha a o navegador, navegador.close fecha apenas a guia atual
        navegador.quit();

    }

    @Test

    public void scraping(){

        WebDriver webDriver = new ChromeDriver();


        webDriver.get("https://www.netacad.com/pt-br/courses/packet-tracer/introduction-packet-tracer");

    }

}
