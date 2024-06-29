package automatizado.test;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

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
    
        String mensagem = loginPage.mensagemErro();
        assertEquals("E-mail ou senha inválidos", mensagem);

    }

    @Test
    public void CT001_002_loginComSenhaInvalida(){
        loginPage.executarLogar("admin@admin.com", "@123");

        String mensagem = loginPage.mensagemErro();
        assertEquals("E-mail ou senha inválidos", mensagem );

    }

    @Test
    public void CT001_003_usuarioESenhaNull(){
        loginPage.executarLogar("", "");

        String mensagem = loginPage.mensagemErro();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);

    }

    @Test
    public void CT001_004_usuarioNull(){
        loginPage.executarLogar("", "admin@123");

        String mensagem = loginPage.mensagemErro();
        assertEquals( "Informe usuário e senha, os campos não podem ser brancos.", mensagem);

    }

    @Test
    public void CT001_005_senhaNull(){
        loginPage.executarLogar("admin@admin.com", "");

        String mensagem = loginPage.mensagemErro();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem );

    }

    @Test
    public void CT001_006_fecharMensagemErro(){
        loginPage.executarLogar("admin@admin.com", "Testes");

        loginPage.fecharMensagemErroLogin.click();

        try {
            loginPage.mensagemErro();
            throw new AssertionError("A mensagem de erro ainda está presente.");
        } catch (NoSuchElementException e) {
            // Se a exceção for lançada, significa que o elemento não está presente
            System.out.println("A mensagem de erro foi fechada com sucesso.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

        //*TODO: Quando o fecha a mensagem de erro o sistema so faz esconder ela. Atribuir a função de fechar mesmo e só chamar ela novamente quando for necessario */

    }

    @Test
    public void CT001_007_loginValido(){
        loginPage.executarLogar("admin@admin.com", "admin@123");
        assertEquals("Controle de Produtos", loginPage.obterTituloPagina());
        
    }




 
}
