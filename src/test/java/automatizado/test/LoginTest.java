package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends baseTest{
    
    private static LoginPO loginPage;



    @BeforeClass
    public static void iniciarTeste(){
        loginPage = new LoginPO(driver);

    }

    @Test
    public void CT001_001_loginComEmailNaoEncontrado(){

        loginPage.executarLogar("teste@teste.com", "admin@123");
    
        String mensagem = loginPage.obterResultado();
        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

    @Test
    public void CT001_002_loginComSenhaInvalida(){
        loginPage.executarLogar("admin@admin.com", "@123");

        String mensagem = loginPage.obterResultado();
        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

    @Test
    public void CT001_003_usuarioESenhaNull(){
        loginPage.executarLogar("", "");

        String mensagem = loginPage.obterResultado();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void CT001_004_loginValido(){
        loginPage.executarLogar("admin@admin.com", "admin@123");
        assertEquals("Controle de Produtos", loginPage.obterTituloPagina());
        
    }




 
}
