package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;
import pages.MePage;
import pages.SecretPage;
import suporte.Screenshot;
import suporte.GeradorTime;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTestData.csv")
public class InformacoesUsuarioTeste {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = new Web().createChrome();

        new HomePage(navegador)
                .clickSignIn()
                .completeLogin("ramon92","123456");
    }

    @Test
    public void testeValidarSaudacaoLogin(){
      String saudacaoTexto = new BasePage(navegador)
                .textSaudacao();

      Assert.assertEquals("Hi, Ramon", saudacaoTexto);
      Screenshot.tirar(navegador, "imagens/screenshot" + GeradorTime.tempoArquivo() + "-Validação.png");
    }

    @Test
    public void testeAdicionandoInformacoesUsuario(
            @Param(name = "tipo") String tipo
           ,@Param(name="contato")String contato
           ,@Param(name = "mensagem") String mensagem){

       String toastText = new SecretPage(navegador)
                .clickMePage()
                .clickMoreDataAboutYou()
                .clickAddMoreData()
                .insertContact(tipo, contato)
               .toastText();

        Assert.assertEquals(mensagem, toastText);

        Screenshot.tirar(navegador, "imagens/screenshot" + GeradorTime.tempoArquivo() + "-Inserindo.png");
    }

    @Test
    public void testeRemovendoInformacoesUsuario(
             @Param(name="contato")String contato
            ,@Param(name = "mensagem") String mensagem){
        new SecretPage(navegador)
                .clickMePage()
                .clickMoreDataAboutYou();                ;
        String toastText =  new MePage(navegador)
                .clickRemove(contato)
                .clickAlert()
                .toastText();

        Assert.assertEquals(mensagem, toastText);
        Screenshot.tirar(navegador, "imagens" + GeradorTime.tempoArquivo() + "-Removendo.png");
    }

   @After
   public void tearDown(){
       navegador.quit();
   }

}
