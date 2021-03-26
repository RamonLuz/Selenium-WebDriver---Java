package pages;

import org.openqa.selenium.WebDriver;

public class PopUpAlert extends BasePage{
    public PopUpAlert(WebDriver navegador) {
        super(navegador);
    }

    public MePage clickAlert(){
        navegador.switchTo().alert().accept();

        return new MePage(navegador);
    }
}
