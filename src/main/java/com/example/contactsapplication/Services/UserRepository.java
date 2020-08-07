package com.example.contactsapplication.Services;

import com.example.contactsapplication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
