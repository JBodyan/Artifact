package com.artifact.app.domain.other;

import lombok.Data;

@Data
public class Message {
    private int id;
    private String type;
    private String message;

    public Message(int id,String type ,String message) {
        this.id = id;
        this.type = type;
        this.message = message;
    }
}
