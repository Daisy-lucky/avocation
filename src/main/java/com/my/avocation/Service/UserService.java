package com.my.avocation.Service;


import com.my.avocation.entity.User;
import com.my.avocation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User login(String uname,String psw){
        User user = userRepository.findByUnameAndPassword(uname, psw);

        return user;
    }
}
