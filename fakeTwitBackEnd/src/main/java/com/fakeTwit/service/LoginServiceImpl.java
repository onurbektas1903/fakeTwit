package com.fakeTwit.service;

import com.fakeTwit.entity.User;
import com.fakeTwit.exception.CustomException;
import com.fakeTwit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation= Propagation.REQUIRED)
@Service("loginService")
public class LoginServiceImpl implements LoginService{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User fakeLogin(User userClient) {
        if(userClient == null ||userClient.getUserName()== null ||userClient.getPassword() == null){
            throw new CustomException("Geçersiz Kullanıcı Adı veya Parolası girilmemiş");
        }
        User userDb =  userRepository.findByUserName(userClient.getUserName());
        if(userDb == null){
           throw new CustomException("Geçersiz Kullanıcı Adı veya Parolası");
        }else if(!userClient.getPassword().equals(userDb.getPassword())){
            throw new CustomException("Geçersiz Kullanıcı Adı veya Parolası");

        }else{
            return userDb;
        }
    }


}
