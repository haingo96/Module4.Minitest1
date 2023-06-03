package com.example.minitest_week1.service;

import com.example.minitest_week1.model.Content;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IContentManager")
public class ContentManager implements IContentManager{

    static {
        contents.add(new Content(1, "content1", "sdfasfdasfdasdferwt"));
        contents.add(new Content(2, "content2", "kgkjgkjgkhgkjgkjhgkjhk"));
        contents.add(new Content(3, "content3", "ytiytitiytitiytiytiuyt"));
        contents.add(new Content(4, "content4", "uoiuoiyoyoyuouyoiuyouyou"));
        contents.add(new Content(5, "content5", "hkjghkgkjhgkhgkhgkhgkhgk"));
    }

    @Override
    public List<Content> getAllContents() {
        return contents;
    }

    @Override
    public void add(Content content) {
        contents.add(content);
    }

    @Override
    public void edit(Content content) {
        Content matchContent = getContentById(content.getId());
        matchContent.setTitle(content.getTitle());
        matchContent.setContentBody(content.getContentBody());
    }

    @Override
    public void delete(int id) {
        Content matchCotent = getContentById(id);
        contents.remove(matchCotent);
    }

    @Override
    public Content getContentById(int id) {
        Content content = contents.stream().filter(content1 -> content1.getId() == id).findFirst().get();
        return content;
    }
}
