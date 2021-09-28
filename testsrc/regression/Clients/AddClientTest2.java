package regression.Clients;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Login;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;

import static utilities.ConfigReader.*;

public class AddClientTest2 extends DoLogin {


    @Test
    public void addClientTest() throws IOException {

        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setLanguage("Spanish");

        /*addClient.setTxtName("Ayushee");
        addClient.setTxtSurname("xyz");
        addClient.setTxtAdd1("abcd1");
        addClient.setTxtAdd2("abcd2");
        addClient.setTxtCity("pune");
        addClient.setTxtState("MH");
        addClient.setTxtZip("78787878");
        addClient.setTxtPhone("8989");
        addClient.setTxtFax("9099");
        addClient.setTxtMobile("998989");
        addClient.setTxtEmail("a@b.com");
        addClient.setTxtWeb("www.xyz.com");
        addClient.setTxtVat("89899");
        addClient.setTxtTax("898989");
        addClient.clickBtnSave();*/

    }
}
