package com.example.contactsapplication.Services;

import com.example.contactsapplication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

     @Query(value = "select * from User e where e.name like %:keyword% or e.email like %:keyword%", nativeQuery = true)
     List<User> findByKeyword(@Param("keyword")String keyword);

}
