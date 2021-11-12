package DataDrivenFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDemo {

    @Test (dataProvider = "getData")
    public void logintest1(String username,String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUser = driver.findElement(By.id("login-username"));
        txtUser.sendKeys(username);

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys(password);

        WebElement btnLogin = driver.findElement(By.name("submit"));
        //btnLogin.click();



    }

    @DataProvider
    public  Object[][] getData()
    {
        Object[][] data = new Object[3][2];

        data[0][0] = "admin";
        data[0][1] = "admin";

        data[1][0] = "yytyty";
        data[1][1] = "ytyty";

        data[2][0] = "";
        data[2][1] = "";

        return data;
    }
}
