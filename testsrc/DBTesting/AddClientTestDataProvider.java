package DBTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static util.Conversion.*;
import static util.DataProviderMethod.testData;

public class AddClientTestDataProvider extends DoLogin {


    @Test (dataProvider = "getData")
    public void addClientTest(String name,String surname,
                              String language,String address1,
                              String address2,String city,String state,
                              String zip,String country,String gender,
                              String birthdate,String phone,String fax,
                              String mobile,String email,String web,
                              String vat,String tax) throws IOException, ClassNotFoundException, SQLException, ParseException {


        ArrayList<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(address1);
        expected.add(address2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);



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

        // 1. loading a driver
             Class.forName("com.mysql.cj.jdbc.Driver");

        //2. creating a connection
        String url ="jdbc:mysql://localhost:3306/ip";
        String username ="root";
        String password ="root";
        Connection con = DriverManager.getConnection(url,username,password);

        // 3. creating statement
        Statement st = con.createStatement();

        // 4. execute the query
        String sql = "select * from ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while(rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));
            //convertCountry

            String shortCountry = rs.getString("client_country");
            String fullCountry = convertCountry(shortCountry);

            actual.add(fullCountry);

            actual.add(convertGender(rs.getString("client_gender")));


            actual.add(convertDate(rs.getString("client_birthdate")));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"some fields are not matching");

  }

    @DataProvider
    public Object[][] getData() throws IOException {
        return testData("Data/MyData.xlsx","DB Testing");
    }

}
