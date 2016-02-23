package com.meetpeople.lightsoo.mymeeting.Data;

/**
 * Created by LG on 2016-02-19.
 */
public class User {

    public String id;
    public String password;
    public String firstname;
    public String lastname;
    public String sex;
    public int age;
    //constructor
    public User(){}
    public User(String id, String password){
        this.id = id;
        this.password = password;
    }
    public User(String id, String password, String firstname, String lastname, String sex, int age) {
        this.id = id;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.age = age;
    }
    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //getter
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}
