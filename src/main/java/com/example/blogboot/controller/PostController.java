package com.example.blogboot.controller;

import com.example.blogboot.domain.Posts;
import com.example.blogboot.service.AuthorService;
import com.example.blogboot.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    private final AuthorService authorService;
    private final PostService postService;

    public PostController(AuthorService authorService, PostService postService) {
        this.authorService = authorService;
        this.postService = postService;
    }

    @GetMapping("/post")
    public String createPost(Model model){
        model.addAttribute("post",new Posts());
        model.addAttribute("authors",authorService.findAll());
        return "admin/postForm";
    }
    @PostMapping("/post")
    public String processPost(@Valid Posts post, RedirectAttributes redirectAttributes,
                              Model model, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("authors",authorService.findAll());
            return "admin/postForm";
        }

        postService.create(post);
        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/posts";
    }
    @GetMapping("/posts")
    public  String showAllPosts(Model model){

        model.addAttribute("posts",postService.findAll());
        model.addAttribute("success"
                ,model.containsAttribute("success"));
        return "posts";
    }

    @ModelAttribute(name = "categories")
    public List<String> categories(){
        return Arrays.asList("Horror","Tragedy","Si-Fi","Romance","Travel");
    }

    @GetMapping("/posts/{postid}")
    public String showPostDetails(@PathVariable int postid, Model model){
        model.addAttribute("post",postService.findById(postid));
        return "post";
    }
}
