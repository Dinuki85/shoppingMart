package com.online.repository;

import com.online.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    //Find the user by the email
    public User findByEmail(String username);




}
