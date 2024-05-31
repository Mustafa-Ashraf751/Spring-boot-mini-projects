package com.project3.librarymangement.repository;

import com.project3.librarymangement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
