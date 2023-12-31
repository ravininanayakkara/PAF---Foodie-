package com.example.demo.Repository;

import com.example.demo.Model.Post;
import com.example.demo.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findUserByname(String name);

    //kalin gahapu mail ekk gahala aai signup wenna ba ekama mail eken
    @Query("{'email':?0}")
    Optional<User> findUserByEmail(String email);



}
