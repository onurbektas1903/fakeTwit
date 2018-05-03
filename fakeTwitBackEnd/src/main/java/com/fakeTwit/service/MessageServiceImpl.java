package com.fakeTwit.service;

import com.fakeTwit.entity.UserMessage;
import com.fakeTwit.exception.CustomException;
import com.fakeTwit.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    MessageRepository messageRepository;

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void appendMessageToUser(UserMessage userMessage) {
            if(userMessage == null ){
                throw new CustomException("Mesaj bilgisi boş");
            }
            if(userMessage.getMessage() == null || userMessage.getMessage().equals("")){
                userMessage.setMessage("Hiç bir şey düşünmüyorum");
            }
            if(userMessage.getSendBy()==null){
                throw new CustomException("Gönderen bilgisi boş");
            }
                this.messageRepository.save(userMessage);
    }

    @Override
    public List<UserMessage> listMessages() {
            List<UserMessage>  userMessages= messageRepository.findAllByOrderByCreatedTimeDesc();
            return userMessages;

    }
}
