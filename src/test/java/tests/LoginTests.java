package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


//    @BeforeMethod
//    public void preconditions(){
//        if(app.getUser().isLogged()){
//            app.getUser().logout();
//        }
//    }
    @Test public void loginPositive(){

        String email = "efpyi@example.com", password = "@#Aa12345)";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        //
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("[href='/logout?url=%2Fsearch']")));

    }

//    @AfterMethod
//    public void tearDown(){
//
//
//    }

}
