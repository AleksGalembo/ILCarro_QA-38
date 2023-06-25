package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @BeforeMethod
    public void preconditions(){
        if(app.getUser().isLogged())//как-то вызвали цепочкой, у меня почемуто не работает
        {
          app.getUser().logout();
        }
    }
    @Test public void loginNegativeUser(){

        String email = "abc11@def.com", password = "$Abcdef12345";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        //app.getUser().submitLogin();
        app.getUser().pause(3000);

        Assert.assertEquals(app.getUser().elementGetText
                (By.xpath("//*[@role='dialog']//h2")),"Login or Password incorrect");
        //как устроена цепочка? Чейн, методы возвращаюстя кроме войдов
        // и для этого необходимо модифицировать сеттеры так чтобы вернуть что-то полезное
        //
        app.getUser().submitFailedLogin();



    } @Test public void loginPositiveUserData (){

        User user = new User()
                .withEmail("abc@def.com")
                .withPassword("$Abcdef12345")
                ;
        //
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        //
       // Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("[href='/logout?url=%2Fsearch']")));
//        Assert.assertEquals(app.getUser().elementGetText
//                (By.xpath("//*[@role='dialog']//h2")),"Logged in success");
//        //
      Assert.assertTrue(app.getUser().isLoggedSuccess());

    }


    @AfterMethod
    public void postconditions(){
//        if(app.getUser().isDialogWindowPresent()){//если из диалог
//           app.getUser().closeDialogWindow();//
//        }
        app.getUser().clickOkButton();// -- убираем кнопку "OK"

    }

}
