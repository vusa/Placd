package com.placd.model

class Company{
    int id;
    String name;
    String logo;
    String contactEmail;
    String contactPhone;
    Recruiter owner;
    String toString(){
        return name;
    }
}