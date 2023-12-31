package tests;

import models.Car;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase {
    @BeforeMethod
    public void preconditions(){

        if (app.getUser().isLogged()==false)
            app.getUser().login(
                    new User().withEmail("asd@fgh.com").withPassword("$Asdf1234"));
    }

    @Test
    public void addNewCarPositive()  {
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        Car car = Car.builder()
                .location("Tel Aviv")
                .manufacture("KIA")
                .model("Sportage")
                .year("2020")
                .fuel("Petrol")
                .seats("5")
                .carClass("Hybrid")
                .carRegNumber("100-200-"+i)
                .price("150")
                .about("")
                .build();

        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getUser().submitLogin();

              //построение объекта с помощью ломбока(библиотеки)
        //курсивом обозначаются статические методы



    }
}
