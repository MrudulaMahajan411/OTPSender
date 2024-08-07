package com.example.Springboot_OTP_Sender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Springboot_OTP_Sender.Entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
