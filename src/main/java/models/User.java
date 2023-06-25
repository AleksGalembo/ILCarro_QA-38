package models;

import org.openqa.selenium.By;

public class User {

    String name;

    String lastName;

    String email;

    String password;



//    public User(String name, String lastName, String email, String password) {
//        this.name = name;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//    }
//
//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    } //куча кастомных конструкторов очень плохо для описания сущности, которая содержит много полей
    // дефолтный конструктор бежит по всем полям и присваивает значения
    //сеттеры позволяют назначить значения, геттеры взять
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User withName(String name) {
        this.name = name;
        return this; // - This - верни ссылку на объект
        // в отношении которого вызывается данный(указанынй) метод
        // по сути мы модернизировали сеттер
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }



}


