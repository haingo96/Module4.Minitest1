package com.example.minitest_week1.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Content {
    private int id;
    private String title;
    private String contentBody;
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    public Content() {
    }

    public Content(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.contentBody = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentBody() {
        return contentBody;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
