package com.fakeTwit.service;

import com.fakeTwit.entity.Message;
import com.fakeTwit.entity.User;

import java.util.List;

public interface MessageService {
    public void appendMessageToUser(Message message);
    public List<Message> listMessages();
}
