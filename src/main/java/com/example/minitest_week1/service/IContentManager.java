package com.example.minitest_week1.service;

import com.example.minitest_week1.model.Content;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface IContentManager {
    List<Content> contents = new ArrayList<>();

    List<Content> getAllContents();

    void add(Content content);

    void edit(Content content);

    void delete(int id);

    Content getContentById(int id);
}
