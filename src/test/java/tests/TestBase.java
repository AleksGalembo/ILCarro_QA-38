package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase {

    static ApplicationManager app = new ApplicationManager();//через ссылку на объект


    @BeforeSuite
    public void setUp(){
        app.init();

    }

    @AfterSuite
    public void stop(){
        app.tearDown();
    }
}
