package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    HelperUser user;// для связи с tests

    public HelperUser getUser() {
        return user; //generate getter user
        //через этот метод мы получаем доступ к объекту класса юзер
        //
    }

    @BeforeSuite
    public void init(){
        wd = new ChromeDriver();
        user = new HelperUser(wd);// для связи с tests
        wd.navigate().to("https://ilcarro.web.app/login?url=%2Fsearch");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

//    @AfterSuite
//    public void tearDown(){
//        wd.quit();
//    }
}
