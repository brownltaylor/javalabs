package com.brown.userinfo.service;
import com.brown.userinfo.domain.UserInfo;
import com.brown.userinfo.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> getAllUsers() {
        Iterable<UserInfo> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity<?> saveUser(UserInfo user) {
        userRepository.save(user);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    public ResponseEntity<?> getUser(Long id){
        Optional<UserInfo> user = userRepository.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<?> update(UserInfo user){
        UserInfo newUser = userRepository.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}



