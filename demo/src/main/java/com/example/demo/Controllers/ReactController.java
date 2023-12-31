package com.example.demo.Controllers;

import com.example.demo.Model.Post;
import com.example.demo.Model.React;
import com.example.demo.Model.User;
import com.example.demo.Service.PostService;
import com.example.demo.Service.ReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/react")
public class ReactController {

    @Autowired
    private ReactService reactService;
    @PostMapping(value = "/set" ,consumes = "application/json")
    public String saveUser(@RequestBody React react) {
        reactService.saveReact(react); // create react when creating post
        return react.getId();
    }

    //get post reacts according to react counts
    @GetMapping(value = "/{postId}")
    public List<React> getHaha(@PathVariable String postId){
        System.out.println(postId);
        return reactService.singleUser(postId);
    }

    //update/delete haha
    @PutMapping("/{id}")
    public void updateHaha(@PathVariable("id") String id, @RequestBody React react) {
        reactService.updateHaha(id, react);
    }

    //update/delete heart
    @PutMapping("heart/{id}")
    public void updateHeart(@PathVariable("id") String id, @RequestBody React react) {
        reactService.updateHeart(id, react);
    }
}
