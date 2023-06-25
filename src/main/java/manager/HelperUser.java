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


    public void openRegistrationForm(){
        wd.findElement(By.xpath("//*[.=' Sign up ']")).click();
    }


    public void fillLoginForm
            (String email, String password) {
        type(By.cssSelector("[id$='email']"), email);// //button[@type='submit']
        type(By.cssSelector("[id$='password']"), password);
    }

    public void fillLoginForm
            (User user) {
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }


    public void fillRegistrationForm(User user){
        type(By.xpath("//input[@id='name']"), user.getName());
        type(By.xpath("//input[@id='lastName']"), user.getLastName());
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
        click(By.cssSelector("label[for='terms-of-use']"));
    }

//    public void submitRegistration(){
//        click(By.xpath("?"));
//    }

    public void submitLogin(){
        wd.findElement(By.xpath("//button[@type='submit']")).submit();
    }
    public void submitFailedLogin(){
        click(By.xpath("//button[@type='button']"));
    }


    public void logout(){
        click(By.xpath("//*[.=' Logout ']"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[.=' Logout ']"));
    }



    public boolean isLoggedSuccess(){
        return isElementPresent(By.xpath("//h2[contains(text(), 'success')]"));
    }

    public boolean isDialogWindowPresent(){
        return isElementPresent(By.xpath("//*[@role='dialog']"));
    }

    public void closeDialogWindow (){
        click(By.xpath("//*[@type='button']"));
    }

    //
    public void clickOkButton(){
       click(By.xpath("//button[@type='button']"));
    }

    public void login (User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        clickOkButton();
    }



}
