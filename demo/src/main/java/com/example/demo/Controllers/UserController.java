package com.example.demo.Controllers;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //Save user in DB
    @PostMapping(value = "/save")
    public ResponseEntity<Optional<User>> saveUser(@RequestBody User user) {
        if(userService.singleUserByEmail(user.getEmail()).isPresent()){
            return new ResponseEntity<Optional<User>>(HttpStatus.UNAUTHORIZED);
        }
      userService.save(user);
        return new ResponseEntity<Optional<User>>(HttpStatus.OK);
    }

    //Get user details in profile
    @GetMapping(value = "/{name}")
     public ResponseEntity<Optional<User>> signIn(@PathVariable String name){
         return new ResponseEntity<Optional<User>>(userService.singleUser(name), HttpStatus.OK);
    }

    //update profile pic and bio
    @PutMapping("/{id}")
    public void updateProfile(@PathVariable("id") String id, @RequestBody User user) {
        userService.updateProfile(id, user);
    }
    @PutMapping("/bio/{id}")
    public void updateBio(@PathVariable("id") String id, @RequestBody User user) {
        userService.updateBio(id, user);
    }

//get other user profiles/ get all users for search 
    @GetMapping("")
    public List<User> getAll(){
        return userService.getAllUsers();
    }
}