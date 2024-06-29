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
    
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obterResultado(){
        return this.spanMensagem.getText();
    }

    public void executarLogar(String email, String senha){
        inputEmail.clear();
        inputSenha.clear();
        inputEmail.sendKeys(email);
        inputSenha.sendKeys(senha);
        btnEntrar.click();
    }

    
}
