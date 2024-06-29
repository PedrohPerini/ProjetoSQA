package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"senha\"]")
    public WebElement inputSenha;


    @FindBy(xpath = "//*[@id=\"btn-entrar\"]")
    public WebElement btnEntrar;

    @FindBy(xpath = "//*[@id=\"mensagem\"]")
    public WebElement spanMensagem;

    @FindBy(xpath = "//*[@id=\"link\"]")
    public WebElement linkRecuperarSenha;
    
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto);
    }

    public String obterResultado(){
        return this.spanMensagem.getText();
    }

    public void executarLogin(String email, String senha) {
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        btnEntrar.click();
    }
    
}
