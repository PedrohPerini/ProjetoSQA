package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePO {

        protected WebDriver driver;

       public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
}
