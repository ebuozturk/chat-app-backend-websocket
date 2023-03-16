package com.ebuozturk.chatapp.dto;


import lombok.Data;

@Data
public class MessagePayload {

    private String message;
    private String sender;
    private String receiver;
    private Status status;
    private ChatType type;
}

enum Status {
    JOIN,NEW_MESSAGE
}
enum ChatType {
    GROUP,USER
}
