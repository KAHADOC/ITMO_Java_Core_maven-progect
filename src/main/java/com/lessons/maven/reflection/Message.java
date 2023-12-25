package com.lessons.maven.reflection;

import java.time.LocalDateTime;

public class Message implements Comparable<Message>{
    private String sender;
    private LocalDateTime sent;

    public Message(String sender) {
        this.sender = sender;
        setSent();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getSent() {
        return sent;
    }

    public void setSent() {
        this.sent = LocalDateTime.now();
    }

    @Override
    public int compareTo(Message o) {
        return sent.compareTo(o.sent);
    }
}