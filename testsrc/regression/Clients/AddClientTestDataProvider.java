package regression.Clients;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;

import static util.DataProviderMethod.testData;

public class AddClientTestDataProvider extends DoLogin {


    @Test (dataProvider = "getData")
    public void addClientTest(String name,String surname,
                              String language,String address1,
                              String address2,String city,String state,
                              String zip,String country,String gender,
                              String birthdate,String phone,String fax,
                              String mobile,String email,String web,
                              String vat,String tax,String expected, String xpathActual) throws IOException {

        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setTxtName(name);
        addClient.setTxtSurname(surname);
        addClient.setLanguage(language);
        addClient.setTxtAdd1(address1);
        addClient.setTxtAdd2(address2);
        addClient.setTxtCity(city);
        addClient.setTxtState(state);
        addClient.setTxtZip(zip);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBirthdate(birthdate);
        addClient.setTxtPhone(phone);
        addClient.setTxtFax(fax);
        addClient.setTxtMobile(mobile);
        addClient.setTxtEmail(email);
        addClient.setTxtWeb(web);
        addClient.setTxtVat(vat);
        addClient.setTxtTax(tax);
        addClient.clickBtnSave();


        String actual = "";
        try
        {
            actual = driver.findElement(By.xpath(xpathActual)).getText();

        }
        catch (Exception e)
        {

        }

        Assert.assertEquals(actual,expected,"wrong message / Record failed");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return testData("Data/MyData.xlsx","add Client");
    }

}
