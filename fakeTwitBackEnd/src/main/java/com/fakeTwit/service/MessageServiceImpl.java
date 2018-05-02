package com.fakeTwit.service;

import com.fakeTwit.entity.UserMessage;
import com.fakeTwit.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation= Propagation.REQUIRED)
@Service("messageService")
public class MessageServiceImpl implements MessageService {
   MessageRepository messageRepository;

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void appendMessageToUser(UserMessage message) {
        this.messageRepository.save(message);
    }

    @Override
    public List<UserMessage> listMessages() {
        return messageRepository.findAllByOrderByCreatedTimeDesc();

    }
}
