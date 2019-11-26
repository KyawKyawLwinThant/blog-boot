package com.example.blogboot.service;

import com.example.blogboot.domain.Posts;
import com.example.blogboot.repository.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    private final PostsRepository postsRepository;

    public PostServiceImpl(final PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public Posts create(Posts posts) {
        return postsRepository.save(posts);
    }

    @Override
    public Posts findById(int id) {
        return postsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Posts> findAll() {
        return postsRepository.findAll();
    }
}
