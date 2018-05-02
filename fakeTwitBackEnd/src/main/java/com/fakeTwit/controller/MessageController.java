package com.fakeTwit.controller;

import com.fakeTwit.entity.Message;
import com.fakeTwit.service.LoginService;
import com.fakeTwit.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public HttpStatus appendMessage(@RequestBody Message message) {
         messageService.appendMessageToUser(message);
         return HttpStatus.OK;
    }
    @RequestMapping(value = "listMessages", method = RequestMethod.GET)
    public List<Message> listMessages() {
        return  messageService.listMessages();
    }


}
