package com.fakeTwit.controller;

import com.fakeTwit.entity.UserMessage;
import com.fakeTwit.exception.CustomException;
import com.fakeTwit.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    MessageService messageService;
    @Autowired
    public void setMessageService(MessageService messageService){
        this.messageService =messageService;
    }
    @RequestMapping(value = "appendMessage", method = RequestMethod.POST)
    public void appendMessage(@RequestBody UserMessage userMessage) {

         messageService.appendMessageToUser(userMessage);
    }
    @RequestMapping(value = "listMessages", method = RequestMethod.GET)
    public List<UserMessage> listMessages() {
           return messageService.listMessages();

    }


}
