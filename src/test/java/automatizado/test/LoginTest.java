package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import automatizado.page.LoginPO;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends baseTest {

    private static LoginPO loginPage;

    @BeforeClass
    public static void iniciarTeste() {
        loginPage = new LoginPO(driver);

    }

    @Test
    public void TC001_001_loginComEmailNaoEncontrado() {
        loginPage.executarLogin("teste@teste.com", "admin@123");
        loginPage.btnEntrar.click();
        String mensagem = loginPage.obterResultado();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC001_002_loginComSenhaInvalida() {
        loginPage.executarLogin("admin@admin.com", "dada");
        loginPage.btnEntrar.click();
        String mensagem = loginPage.obterResultado();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC001_003_usuarioESenhaNull() {
        loginPage.executarLogin("", "");
        String mensagem = loginPage.obterResultado();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC001_004_usuarioNull() {
        loginPage.executarLogin("", "admin@123");
        String mensagem = loginPage.obterResultado();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC001_005_senhaNull() {
        loginPage.executarLogin("admin@admin.com", "");
        String mensagem = loginPage.obterResultado();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC001_006_loginValido() {
        loginPage.executarLogin("admin@admin.com", "admin@123");
    }

    @Test
    public void TC001_007_recuperarLogin() {
        loginPage.executarLogin("admin", "admin@123");
        String recuperaSenha = loginPage.linkRecuperarSenha.getText();
        assertEquals(recuperaSenha, "Esqueci minha senha");
    }
}
