package com.placd.model

class AppUser{
    int id;
    String login;
    String email;
    String auth_type;
    String password;
    Date dob;
    Date last_login;
    UserGroup group;
    boolean active;
    
    static constraints = {
        login(size:4..15, blank:false, unique:true)
        password(size:4..15, blank:false)
        email(email:true, blank:false)
    }

    String toString(){
        return name+" ["+id+"]";
    }
}