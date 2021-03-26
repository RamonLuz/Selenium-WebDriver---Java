package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public FormLoginPage clickSignIn(){
        navegador.findElement(By.linkText("Sign in")).click();

        return new FormLoginPage(navegador);
    }
}
