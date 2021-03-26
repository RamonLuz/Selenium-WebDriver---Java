package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormAddContactPage extends BasePage {
    public FormAddContactPage(WebDriver navegador) {
        super(navegador);
    }

    public FormAddContactPage typeContact(String tipo){
        WebElement formContact = navegador.findElement(By.id("addmoredata"));
        new Select(formContact.findElement(By.name("type"))).selectByVisibleText(tipo);

        return this;
    }

    public FormAddContactPage contact(String contato){
        navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);

        return this;
    }

    public MePage clickSave(){
        navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();

        return new MePage(navegador);
    }

    public MePage insertContact(String tipo, String contato){
        typeContact(tipo);
        contact(contato);
        clickSave();

        return new MePage(navegador);
    }
}
