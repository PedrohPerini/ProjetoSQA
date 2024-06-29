package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutosPO extends BasePO  {

    @FindBy(xpath = "//*[@id=\"btn-adicionar\"]")
    public WebElement btnCriar;

    @FindBy(xpath ="//*[@id=\"collapsibleNavbar\"]/ul/li/a")
    public WebElement btnVoltar;

    @FindBy(xpath ="/html/body/nav/a")
    public WebElement btnControleDeProdutos;

    @FindBy(xpath ="//*[@id=\"btn-salvar\"]")
    public WebElement btnSalvarModal;

    @FindBy(xpath ="//*[@id=\"btn-sair\"]")
    public WebElement btnSairModal;

    @FindBy(xpath ="//*[@id=\"cadastro-produto\"]/div/div/div[1]/button")
    public WebElement btnFecharModal;

    @FindBy(xpath ="//*[@id=\"codigo\"]")
    public WebElement inputCodigoModal;
    
    @FindBy(xpath ="//*[@id=\"nome\"]")
    public WebElement inputNomeModal;

    @FindBy(xpath ="//*[@id=\"quantidade\"]")
    public WebElement inputQuantidadeModal;

    @FindBy(xpath ="//*[@id=\"valor\"]")
    public WebElement inputValorModal;

    @FindBy(xpath ="//*[@id=\"data\"]")
    public WebElement inputDataModal;

    @FindBy(xpath ="//*[@id=\"cadastro-produto\"]/div/div/div[1]/h4")
    public WebElement tituloModal;

    @FindBy(xpath ="//*[@id=\"mensagem\"]")
    public WebElement mensagemErro;

    public String obterResultado(){
        return this.mensagemErro.getText();
    }

    public ProdutosPO(WebDriver driver) {
        super(driver);
    }
    

    public boolean checarCampoVazio(){
        String campoVazio = inputCodigoModal.getAttribute("value");
   
        if (campoVazio.equals("")) {
            return true;    
        }else{
            return false;
        }
    }
    
}
