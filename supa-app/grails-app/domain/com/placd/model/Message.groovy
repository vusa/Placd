package com.placd.model

class Message{
    int id
    AppUser toUser;
    AppUser fromUser;
    String subject;
    Message inReplyTo;
    Job job;
    String message;
    boolean read;
    Date timeSent;
    String toString(){
        return subject;
    }
}