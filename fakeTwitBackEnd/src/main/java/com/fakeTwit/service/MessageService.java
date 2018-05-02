package com.fakeTwit.service;

import com.fakeTwit.entity.UserMessage;

import java.util.List;

public interface MessageService {
    public void appendMessageToUser(UserMessage message);
    public List<UserMessage> listMessages();
}
