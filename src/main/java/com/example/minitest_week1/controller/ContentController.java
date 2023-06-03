package com.example.minitest_week1.controller;

import com.example.minitest_week1.model.Content;
import com.example.minitest_week1.service.IContentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContentController {

    @Autowired
    private IContentManager iContentManager;

    @GetMapping("/index")
    public String index(Model model) {
        List<Content> contents = iContentManager.getAllContents();
        model.addAttribute("contents", contents);
        return "/index";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model,@PathVariable int id) {
        Content content = iContentManager.getContentById(id);
        model.addAttribute("content", content);
        return "/edit";
    }

    @PostMapping("/submitEdit")
    public String completeEditContent(Model model, @ModelAttribute Content content) {
        iContentManager.edit(content);
        List<Content> contents = iContentManager.getAllContents();
        model.addAttribute("contents", contents);
        return "/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteContent(Model model, @PathVariable int id) {
        iContentManager.delete(id);
        List<Content> contents = iContentManager.getAllContents();
        model.addAttribute("contents", contents);
        return "/index";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {
        model.addAttribute("newContent", new Content());
        return "/add";
    }

    @PostMapping("/submitAdd")
    public String completeAdd(Model model, @ModelAttribute Content newContent) {
        iContentManager.add(newContent);
        List<Content> contents = iContentManager.getAllContents();
        model.addAttribute("contents", contents);
        return "/index";
    }
}
