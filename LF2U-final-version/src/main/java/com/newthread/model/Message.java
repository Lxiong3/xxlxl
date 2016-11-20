package com.newthread.model;

import java.io.Serializable;

public class Message implements Serializable{

    private String code;
    private String message;
    private Object content;

    public Message() {
    }

    public Message(String code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

}
