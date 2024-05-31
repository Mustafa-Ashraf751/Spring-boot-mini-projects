package com.example.springcurdproject.repository;

import com.example.springcurdproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
