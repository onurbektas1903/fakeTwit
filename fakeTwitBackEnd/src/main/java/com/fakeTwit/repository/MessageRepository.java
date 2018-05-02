package com.fakeTwit.repository;

import com.fakeTwit.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MessageRepository extends CrudRepository<Message,Long> {
    List<Message> findAllByOrderByCreatedTime();


}
