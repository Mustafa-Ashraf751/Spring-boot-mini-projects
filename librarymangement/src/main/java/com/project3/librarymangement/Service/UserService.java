package com.project3.librarymangement.Service;

import com.project3.librarymangement.entity.User;
import com.project3.librarymangement.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public User createUser(User user){
    if(user.getId() != null) {throw new RuntimeException("The user is already exist");}
    return userRepository.save(user);
  }

  public List<User> getUsers(){
    return userRepository.findAll();
  }

}
