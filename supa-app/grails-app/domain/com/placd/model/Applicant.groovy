package com.placd.model

class Applicant{
    int id;
    AppUser user;
    String name;
    String surname;
    String summary;
    Date lastUpdate;
    int expectedMinimunSalary;
    boolean showContactDetails;
    String tags;
    String toString(){
        return name + " " + surname;
    }
}