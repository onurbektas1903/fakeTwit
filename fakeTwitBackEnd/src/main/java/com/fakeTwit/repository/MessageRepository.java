package com.fakeTwit.repository;

import com.fakeTwit.entity.UserMessage;
import com.fakeTwit.entity.UserMessage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MessageRepository extends CrudRepository<UserMessage,Long> {
    List<UserMessage> findAllByOrderByCreatedTimeDesc();


}
