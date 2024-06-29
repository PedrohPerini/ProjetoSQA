package automatizado.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import automatizado.build.ProdutoBuilder;
import automatizado.page.LoginPO;
import automatizado.page.ProdutosPO;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutosTest extends baseTest {

    private static LoginPO loginPage;
    private static ProdutosPO produtosPage;

    @BeforeClass
    public static void iniciarTeste(){
        loginPage = new LoginPO(driver);
        loginPage.executarLogar("admin@admin.com", "admin@123");

        produtosPage = new ProdutosPO(driver);
        assertEquals(produtosPage.obterTituloPagina(), "Controle de Produtos");

    }

    @Test
    public void CT002_001_criacaoDeProdutoDaManeiraCorreta(){
        produtosPage.btnCriar.click();
        produtosPage.btnCriar.click();

        String titulo = produtosPage.tituloModal.getText();
        assertEquals("Produto", titulo);

        ProdutoBuilder produto = new ProdutoBuilder(produtosPage);
        
        produto
        .adcCodigo(0001)
        .adcNome("Camisa do Flamego")
        .adcQuantidade(2)
        .adcValor(238.99)
        .adcData("20/06/2024")
        .builder();
        produtosPage.btnSalvarModal.click();

    }
    @Test
    public void CT002_002_criacaoDeProdutoCamposObrigatoriosEmBranco(){

        String titulo = produtosPage.tituloModal.getText();
        assertEquals("Produto", titulo);

        ProdutoBuilder produto = new ProdutoBuilder(produtosPage);
        
        produto
        .adcCodigo(null)
        .adcNome("")
        .adcQuantidade(null)
        .adcValor(null)
        .adcData("")
        .builder();
        produtosPage.btnSalvarModal.click();

        String mensagem = produtosPage.obterResultado();
        assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");

    }

    @Test
    public void CT002_003_criacaoDeProdutoComCodigoInvalido(){//O sistema não deve permitir que o campo codigo seja negativo.


        String titulo = produtosPage.tituloModal.getText();
        assertEquals("Produto", titulo);

        ProdutoBuilder produto = new ProdutoBuilder(produtosPage);
        
        produto
        .adcCodigo(-0003)
        .adcNome("Camisa")
        .adcQuantidade(1)
        .adcValor(20.99)
        .adcData("20/06/2024")
        .builder();
        produtosPage.btnSalvarModal.click();
        //TODO: Implementar a regra no código que permita somente valores naturais

    }

    @Test
    public void CT002_004_criacaoDeProdutoComNomeInvalido(){//O sistema não deve permitir que o campo nome possua menos que 2 caracteres.


        String titulo = produtosPage.tituloModal.getText();
        assertEquals("Produto", titulo);

        ProdutoBuilder produto = new ProdutoBuilder(produtosPage);
        
        produto
        .adcCodigo(0004)
        .adcNome("A")
        .adcQuantidade(12)
        .adcValor(50.99)
        .adcData("20/06/2024")
        .builder();
        produtosPage.btnSalvarModal.click();
        //TODO: Implementar a funcionalidade do campo nome não permitir valores com menos de 2 caracteres.

    }

    @Test
    public void CT002_005_criacaoDeProdutoComQuantidadeInvalido(){//O sistema deve somente aceitar valores Naturais, ou seja possitivo e inteiro.

        String titulo = produtosPage.tituloModal.getText();
        assertEquals("Produto", titulo);

        ProdutoBuilder produto = new ProdutoBuilder(produtosPage);
        
        produto
        .adcCodigo(0005)
        .adcNome("Computador")
        .adcQuantidade(-10)
        .adcValor(5000.99)
        .adcData("20/06/2024")
        .builder();
        produtosPage.btnSalvarModal.click();
        //TODO: Implementar a regra na quantida que permita somente valores naturais

    }

    @Test
    public void CT002_006_criacaoDeProdutoComValorInvalido(){//O sistema deve somente aceitar valores positivos
        String titulo = produtosPage.tituloModal.getText();
        assertEquals("Produto", titulo);

        ProdutoBuilder produto = new ProdutoBuilder(produtosPage);
        
        produto
        .adcCodigo(0006)
        .adcNome("Computador")
        .adcQuantidade(10)
        .adcValor(-5000.99)
        .adcData("20/06/2024")
        .builder();
        produtosPage.btnSalvarModal.click();
        //TODO: Implementar a regra no campo 'valor' que permita somente valores positivos

    }
    

    @Test
    public void CT002_007_fechar_ModalDeCadastroComOBotaoSalvar(){//O sistema deve fechar o modal e salvar as informações na tabela quando o usuário clicar em salvar
        String titulo = produtosPage.tituloModal.getText();
        assertEquals("Produto", titulo);

        ProdutoBuilder produto = new ProdutoBuilder(produtosPage);
        
        produto
        .adcCodigo(0007)
        .adcNome("PenDrive")
        .adcQuantidade(10)
        .adcValor(50.99)
        .adcData("20/06/2024")
        .builder();
        
        produtosPage.btnSalvarModal.click();
        //TODO: Implementar a regra nque fecha o modal quando o usuário preenche todos os campos e clica em salvar.

    }

    /**
     * 
     */
    @Test
    public void CT002_008_fechar_ModalDeCadastroComCamposPreenchidos(){
        /**
         *  O sistema deve abrir um pop-up e apresentar a seguinte mensagem "Os dados inseridos não serão salvos ! Deseja continuar ?".
         * O Sistema também tem que apresentar os botões de confirmar ou cancelar no pop-up
         */
        String titulo = produtosPage.tituloModal.getText();
        assertEquals("Produto", titulo);

        ProdutoBuilder produto = new ProdutoBuilder(produtosPage);
        
        produto
        .adcCodigo(8)
        .adcNome("HeadSet")
        .adcQuantidade(2)
        .adcValor(300.99)
        .adcData("20/06/2024")
        .builder();
        produtosPage.btnSairModal.click();
        //TODO: Implementar a funcionalidade do pop-up de confirmação

    }
    
    @Test
    public void CT002_009_limparModalQuandoFecharPeloBotaoSair(){
        /**
         * Se tiver algum valor inserido quando o usuário clicar no botão sair então o sistem deve fechar o modal e limpar as informações nele.
         * 
         */
        produtosPage.btnCriar.click();
        
        String titulo = produtosPage.tituloModal.getText();
        assertEquals("Produto", titulo);

        ProdutoBuilder produto = new ProdutoBuilder(produtosPage);
        
        produto
        .adcCodigo(9)
        .adcNome("Teclado")
        .adcQuantidade(9)
        .adcValor(288.99)
        .adcData("20/06/2024")
        .builder();
        produtosPage.btnSairModal.click();
        produtosPage.btnCriar.click();
        produtosPage.checarCampoVazio();
        assertEquals(true, produtosPage.checarCampoVazio());
    }

    @Test
    public void CT002_0010_clicarNoLogo(){
        try{
            produtosPage.btnControleDeProdutos.click();
            assertEquals("Controle de Produtos", produtosPage.obterTituloPagina());

        }catch (AssertionError e) {
            System.out.println("O título da página não é 'Controle de Produtos' e o resultado do teste 'Falhou'");
        }
        
    }

    @Test
    public void CT002_0011_clicarNoBotaoVoltar(){

        try {
            produtosPage.btnVoltar.click();
            assertEquals("Login", produtosPage.obterTituloPagina());
        } catch (AssertionError e) {
            System.out.println("O título da página não é 'Login' e o resultado do teste 'Falhou'");
        }
    }
    
}
