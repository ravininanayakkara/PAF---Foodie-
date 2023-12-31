package com.example.demo.Controllers;

import com.example.demo.Model.Comment;
import com.example.demo.Model.Post;
import com.example.demo.Model.React;
import com.example.demo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    //save post
    //fe eken be ekata data gannawa
    @PostMapping(value = "/upload" ,consumes = "application/json")
    public String saveUser(@RequestBody Post post) {

        postService.save(post);
        return post.getId();
    }

//get post 
    @GetMapping(value = "/get")
    public List<Post> getPost(){
        return postService.get();
    }

    //get post according to user id
    @GetMapping(value = "/{userId}")
    public List<Post> getByUser(@PathVariable String userId){
        return postService.getByPost(userId);
    }

     //delete post according to user id
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id){
        System.out.println(id);
        postService.DeletePost(id);
    }

     //update post according to user id
    @PutMapping(value = "/{id}")
    public void updateResource(@PathVariable String id, @RequestBody Post post) {
        // Update the resource with the specified ID using the data in the request body
        // ...
        postService.updateCaption(id, post);
        // Return a success response
        // ...
    }

}

//save create post, show post, post update
