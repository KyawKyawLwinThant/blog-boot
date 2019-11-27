package com.example.blogboot.repository;

import com.example.blogboot.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts,Integer> {
}
