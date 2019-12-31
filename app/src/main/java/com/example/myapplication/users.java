package com.example.myapplication;

public class users {
String uId;
String usersUn;
String usersPsw;
//String usersPswc;
String usersPn;
String usersEml;

    public  users(){

    }

    public users(String uId,String usersUn, String usersPsw, String usersPn, String usersEml) {
        this.uId = uId;
        this.usersUn = usersUn;
        this.usersPsw = usersPsw;
//        this.usersPswc = usersPswc;
        this.usersPn = usersPn;
        this.usersEml = usersEml;
    }

    public String getUsersUn() {
        return usersUn;
    }

    public String getUsersPsw() {
        return usersPsw;
    }

//    public String getUsersPswc() {
//        return usersPswc;
//    }

    public String getUsersPn() {
        return usersPn;
    }

    public String getuId() {
        return uId;
    }

    public String getUsersEml() {
        return usersEml;
    }
}
