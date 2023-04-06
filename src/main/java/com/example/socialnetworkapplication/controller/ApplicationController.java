package com.example.socialnetworkapplication.controller;

import com.example.socialnetworkapplication.model.Message;
import com.example.socialnetworkapplication.repos.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class ApplicationController {

    private final MessageRepository messageRepository;

    @GetMapping
    public String main(Map<String, Object> map) {
        Iterable<Message> messages = messageRepository.findAll();
        map.put("messages", messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String message, @RequestParam String tag, Map<String, Object> map) {
        Message userMessage = new Message(message, tag);
        messageRepository.save(userMessage);
        Iterable<Message> messages = messageRepository.findAll();
        map.put("message", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> map) {
        Iterable<Message> messages;
        if(filter != null && filter.isEmpty()) {
            messages = messageRepository.findByTag(filter);
        } else {
            messages = messageRepository.findAll();
        }
        map.put("message", messages);
        return "main";
    }
}
