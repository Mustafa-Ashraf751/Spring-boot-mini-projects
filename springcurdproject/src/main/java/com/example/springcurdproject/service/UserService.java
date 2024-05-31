package com.example.springcurdproject.service;

import com.example.springcurdproject.dto.UserDTO;
import com.example.springcurdproject.entity.User;

import java.util.List;

public interface UserService {

  void addUser(User user);

  List<User> getUsers();

  User getUser(Integer id);

  void updateUser(Integer id, User user);

  void deleteUser(Integer id);

  void updateName(Integer id, UserDTO userDTO);
}
