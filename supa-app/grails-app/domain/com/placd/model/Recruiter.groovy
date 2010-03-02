package com.placd.model

class Recruiter{
    int id;
    AppUser user;
    String name
    String surname
    Company company;
    String toString(){
        return name +"["+id+"]";
    }
}