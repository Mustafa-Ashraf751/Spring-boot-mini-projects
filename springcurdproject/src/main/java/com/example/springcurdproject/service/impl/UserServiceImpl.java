package com.example.springcurdproject.service.impl;

import com.example.springcurdproject.dto.UserDTO;
import com.example.springcurdproject.entity.User;
import com.example.springcurdproject.repository.UserRepository;
import com.example.springcurdproject.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
@Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public void addUser(User user) {
   userRepository.save(user);
  }

  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUser(Integer id) {
   User user =
    userRepository.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND
                    ,"Invalid user id"));
   return user;
  }

  @Override
  public void updateUser(Integer id, User user) {
    // check user exist or not
     userRepository.findById(id).orElseThrow(()->
            new ResponseStatusException(
            HttpStatus.NOT_FOUND,"Invalid user id "+id));

    user.setId(id);

    userRepository.save(user);
  }

  @Override
  public void deleteUser(Integer id) {
    //check user exist in db or not
    User user = userRepository.findById(id).orElseThrow(()->
            new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Invalid user id "+id));
    userRepository.delete(user);
  }

  @Override
  public void updateName(Integer id, UserDTO userDTO) {
    //check user exist in db or not
    User user = userRepository.findById(id).orElseThrow(()->
            new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Invalid user id "+id));
    user.setName(userDTO.getName());
    userRepository.save(user);
  }
}
