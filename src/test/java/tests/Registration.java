package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TestBase {

    @BeforeMethod
    public void preconditions(){
        if(app.getUser().isLogged()) app.getUser().logout();
    }

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("john_" + i + "@mail.com")
                .withPassword("$Asdf1234");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser()
                .isLoggedSuccess());

    }
    @Test
    public void registrationNegative(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("john_" + i + "mail.com")
                .withPassword("$Asdf1234");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }



    @AfterMethod
    public void postcondition(){
        app.getUser().clickOkButton();
    }
}