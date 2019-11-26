package com.example.blogboot.service;

import com.example.blogboot.domain.Author;

import java.util.List;

public interface AuthorService {

    Author create(Author author);
    Author findById(int id);
    List<Author> findAll();
}
