package com.placd.model

class Recruiter{
    int id;
    User user;
    String name
    String surname
    Company company;
    String toString(){
        return name +"["+id+"]";
    }
}