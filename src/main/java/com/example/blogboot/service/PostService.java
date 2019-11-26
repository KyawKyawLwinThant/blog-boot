package com.example.blogboot.service;

import com.example.blogboot.domain.Posts;
import java.util.List;

public interface PostService {
    Posts create(Posts posts);
    Posts findById(int id);
    List<Posts> findAll();
}
