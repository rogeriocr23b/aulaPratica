package br.com.juliodelima.taskit.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes Automatizados da Funcionalidade SignUp")
public class SigUpTests {
    @Test
    @DisplayName("Registrar um novo usuário com dados válidos")
    public void testRegistrarUmNovoUsuarioComDadosValidos() {
        // vou abrir o chrome
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        // vou abrir o taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        // vou clicar no botao que tem o ID igual a signup
        navegador.findElement(By.id("signup")).click();

        // vou digitar o nome com o campo name signup name-sign-up
        navegador.findElement(By.id("name-sign-up")).sendKeys("RogerioLindo4");

        // vou digitar o login com o campo login login-sign-up
        navegador.findElement(By.id("login-sign-up")).sendKeys("RogerioL4");

        // vou digitar a senha com o campo password password-sign-up
        navegador.findElement(By.id("password-sign-up")).sendKeys("123456");

        // vou clicar no botão com ID btn-submit-sign-up
        navegador.findElement(By.id("btn-submit-sign-up")).click();

        //validar que o texo Hi RogerioLindo foi apresentado no elemento a.me
        String saudacaoAtual = navegador.findElement(By.className("me")).getText();
        Assertions.assertEquals("Hi, RogerioLindo4",saudacaoAtual);

        // fechar o navegador
        navegador.quit();
    }
}
