package UITesting;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

public class LoginTest extends OpenUrl {
    Login login;

    @BeforeClass
    public void initLoginObject()
    {
        login = new Login(driver);
    }


    @Test
    public void txtUsernameVisibility() {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtUser.isDisplayed();// true / false
        }
        catch (Exception e)
        {
            actual = false;
        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"username text box is not present");
    }


    @Test
    public void txtUsernameEnabilityCheck()
    {
        boolean expected = true;
        boolean actual = false;
        try
        {
            actual= login.txtUser.isEnabled();
        }
        catch (Exception e)
        {
            actual = false;
        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"username text box is disabled");
    }

    @Test
    public void lblPasswordSpellCheck()
    {
        String expected = "Password";
        String actual="";

        try
        {
            actual = login.lblPassword.getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);


        Assert.assertEquals(actual,expected,"incorrect spelling");
    }

    public void txtEmailWatermarkCheck()
    {
        String expected = "Email";
        String actual = "";
        try
        {
            actual = login.txtUser.getAttribute("placeholder");
        }
        catch (Exception e)
        {

        }
        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"incorrect text");
    }


    @Test
    public void lblPasswordCheckFontSize()
    {
        String expected = "14px";
        String actual="";
        try
        {
            actual= login.lblPassword.getCssValue("font-size");
        }
        catch (Exception e)
        {

        }
        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"incorrect font-Size");
    }


    @Test
    public void lblPasswordFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";

        String actual="";
        try
        {
            actual= login.lblPassword.getCssValue("font-family");
        }
        catch (Exception e)
        {

        }
        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"incorrect font-family");

    }

    @Test
    public void lblPasswordFontCheck()
    {
        String expected = "sans-serif";

        String actual="";
        try
        {
            actual= login.lblPassword.getCssValue("font-family");
        }
        catch (Exception e)
        {

        }

        boolean result = actual.contains(expected);

       Assert.assertTrue(result);

    }

    @Test
    public void btnLoginColorCheck()
    {
        String expected = "#2C8EDD";

        String actual="";
        try
        {
            String rgbColor= login.btnLogin.getCssValue("background-color");
            actual = Color.fromString(rgbColor).asHex().toUpperCase();
        }
        catch (Exception e)
        {

        }
        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"incorrect background-color");


    }
}

