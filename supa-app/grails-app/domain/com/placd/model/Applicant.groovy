package com.placd.model

class Applicant{
    int id;
    User user;
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