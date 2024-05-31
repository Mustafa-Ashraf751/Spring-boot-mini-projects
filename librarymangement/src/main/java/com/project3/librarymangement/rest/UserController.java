package com.project3.librarymangement.rest;

import com.project3.librarymangement.Service.UserService;
import com.project3.librarymangement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserService userService;
@Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public User createUser(@RequestBody User user){
  return userService.createUser(user);
  }

  @GetMapping
  public List<User> getUsers(){
    return userService.getUsers();
  }
}
