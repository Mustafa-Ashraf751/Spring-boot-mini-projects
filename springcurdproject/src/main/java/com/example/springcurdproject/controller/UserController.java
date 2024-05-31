package com.example.springcurdproject.controller;

import com.example.springcurdproject.UserNotFoundException;
import com.example.springcurdproject.dto.UserDTO;
import com.example.springcurdproject.entity.User;
import com.example.springcurdproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/add")
  public String addUser(@RequestBody User user){
    userService.addUser(user);
    return "success and user added";
  }

  @GetMapping()
  public List<User> getUsers(){
    return userService.getUsers();
  }

  @GetMapping("get")
  public User getUser(@RequestParam Integer id){
    return userService.getUser(id);
  }

  @PutMapping("/update/{id}")
  public void updateUser(
          @PathVariable Integer id,
          @RequestBody User user){
    List<User> users = userService.getUsers();
    if(id < 0 || id >= users.size() ){
      throw new UserNotFoundException
              ("The user you want don't exist");}
    userService.updateUser(id,user);

  }

  @DeleteMapping("/delete/{id}")
  public void deleteUser(
          @PathVariable Integer id){
    List<User> users = userService.getUsers();
    if(id < 0 || id >= users.size() ){
      throw new UserNotFoundException
              ("The user you want don't exist");}
    userService.deleteUser(id);
  }

  @PatchMapping("/update-name/{id}")
  public ResponseEntity<Void> updateName(
          @PathVariable Integer id,
          @RequestBody UserDTO userDTO){
    userService.updateName(id,userDTO);

    return ResponseEntity.noContent().build();
  }


}
