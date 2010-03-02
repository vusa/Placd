package com.placd.model

class AppUser{
    int id;
    String name;
    String email;
    String auth_type;
    String password;
    Date dob;
    Date last_login;
    UserGroup group;
    boolean active;

    String toString(){
        return name+" ["+id+"]";
    }
}