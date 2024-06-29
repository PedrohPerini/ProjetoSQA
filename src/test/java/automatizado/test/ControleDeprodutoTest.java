package automatizado.test;

import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeprodutoTest extends baseTest {
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;

    @BeforeClass
    public static void iniciarTeste() {
        loginPage = new LoginPO(driver);
        loginPage.executarLogin("admin@admin.com", "admin@123");
        controleProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC002_001_criacaoDeProduto() {
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.escrever(controleProdutoPage.inputNome, "Produto Teste");
        controleProdutoPage.escrever(controleProdutoPage.inputCodigo, "123");
        controleProdutoPage.escrever(controleProdutoPage.inputQuantidade, "10");
        controleProdutoPage.escrever(controleProdutoPage.inputValor, "10");
        controleProdutoPage.escrever(controleProdutoPage.dataData, "10-10-2010");
        controleProdutoPage.buttonSalvar.click();

    }

}
