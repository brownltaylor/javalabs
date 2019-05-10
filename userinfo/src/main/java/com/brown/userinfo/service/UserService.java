package com.brown.userinfo.service;
import com.brown.userinfo.domain.UserInfo;
import com.brown.userinfo.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<UserInfo> list() {
        return userRepository.findAll();
    }

    public UserInfo save(UserInfo user) {
        return userRepository.save(user);
    }

    public void save(List<UserInfo> users) {
        userRepository.save(users);
    }
}



