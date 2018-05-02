package com.fakeTwit.repository;

import com.fakeTwit.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {
    User findByUserName(String userName);
}
