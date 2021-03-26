package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage{
    public MePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clickMoreDataAboutYou(){
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public FormAddContactPage clickAddMoreData(){
        navegador.findElement(By.xpath("//button[@data-target='addmoredata']")).click();

        return new FormAddContactPage(navegador);

    }

    public PopUpAlert clickRemove(String contato){
            navegador.findElement(By.xpath("//span[text()=\""+ contato +"\"]/following-sibling::a")).click();

        return new PopUpAlert(navegador);
    }



}
