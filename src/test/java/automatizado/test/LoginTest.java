package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.page.LoginPO;

public class LoginTest extends baseTest{
    
    private static LoginPO loginPage;

    @BeforeClass
    public static void iniciarTeste(){
        loginPage = new LoginPO(driver);

    }

    @Test
    public void TC001_001_loginValido(){
        loginPage.inputEmail.sendKeys("admin@admin.com ");
        loginPage.inputSenha.sendKeys("admin@123");
        loginPage.btnEntrar.click();
    }

    @Test
    public void CT001_003_loginComEmailNaoEncontrado(){
        loginPage.inputEmail.sendKeys("admin@admin.com ");
        loginPage.inputSenha.sendKeys("admin@123");
        loginPage.btnEntrar.click();

    }

    @Test
    public void CT001_004_loginComSenhaInvalida(){
        loginPage.inputEmail.sendKeys("teste@teste.com ");
        loginPage.inputSenha.sendKeys("admin@123");
        loginPage.btnEntrar.click();
        String mensagem = loginPage.obterResultado();
        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

    @Test
    public void CT001_006_usuarioESenhaNull(){
        loginPage.inputEmail.sendKeys("");
        loginPage.inputSenha.sendKeys("");
        loginPage.btnEntrar.click();
        String mensagem = loginPage.obterResultado();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }



 
}
