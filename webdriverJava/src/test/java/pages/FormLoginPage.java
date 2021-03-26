package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormLoginPage extends BasePage{
    public FormLoginPage(WebDriver navegador) {
        super(navegador);
    }

    public FormLoginPage insertLogin(String login){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        return this;
    }

    public FormLoginPage insertPassword(String password){
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

        return this;
    }

    public SecretPage clickSignIn(){
        navegador.findElement(By.id("signinbox")).findElement(By.linkText("SIGN IN")).click();

        return new SecretPage(navegador);
    }

    public SecretPage completeLogin(String login, String password){
        insertLogin(login);
        insertPassword(password);
        clickSignIn();

        return new SecretPage(navegador);
    }
}
