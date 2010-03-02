package com.placd.model

class Message{
    int id
    User toUser;
    User fromUser;
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