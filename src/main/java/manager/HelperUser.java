package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {



    public HelperUser(WebDriver wd) {
        super(wd); // для связи с tests (навели мышеой на HelperUser если он крассный)

    }

    public void openLoginForm(){
        wd.findElement(By.cssSelector("[href='/login?url=%2Fsearch']")).click();
    }

    public void fillLoginForm
            (String email, String password) {
        type(By.cssSelector("[id$='email']"), email);// //button[@type='submit']
        type(By.cssSelector("[id$='password']"), password);
    }

    public void fillLoginForm
            (User user) {
        type(By.cssSelector("[id$='email']"), user.getEmail());// //тут мы видим признаки полиморфизма (оверлодинг)
        type(By.cssSelector("[id$='password']"), user.getPassword());
    }

//    public void submitRegistration(){
//        click(By.xpath("?"));
//    }

    public void submitLogin(){
        click(By.cssSelector("button[type='submit']"));
    }



    public void logout(){
        click(By.cssSelector("[href=\"/logout?url=%2Fsearch\"]"));
    }

    public boolean isLogged(){
        return isElementPresent(By.cssSelector("[href=\"/logout?url=%2Fsearch\"]"));
    }

    public boolean isDialogWindowPresent(){
        return isElementPresent(By.xpath("//*[@role='dialog']"));
    }

    public void closeDialogWindow (){
        click(By.xpath("//*[@type='button']"));
    }
}
