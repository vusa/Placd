package com.placd.model

class Job{
    int id;
    Recruiter recruiter;
    String title;
    Company company;
    String jobSpecs;
    Date datePosted
    Date closingDate;
    int salary_min
    int salary_max
    String city
    String country
    String tags
    String toString(){
        return title;
    }
}