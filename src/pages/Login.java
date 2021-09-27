package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
   // WebDriver driver;
   // WebElement txtUser = driver.findElement(By.id(""));

    @FindBy (xpath="//input[@id='email']")
    WebElement txtUser;

    @FindBy(xpath = "//input[@id='password']")
    WebElement txtPass;

    @FindBy(xpath = "//a[normalize-space()='I forgot my password']")
    WebElement lnkForgotPass;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btnLogin;

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickForgotPassword()
    {
        lnkForgotPass.click();
    }

    public void setTxtUser(String username)
    {
        txtUser.sendKeys(username);
    }

    public void setTxtPass(String password)
    {
        txtPass.sendKeys(password);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }

}
