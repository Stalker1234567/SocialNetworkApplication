package com.example.socialnetworkapplication.controller;

import com.example.socialnetworkapplication.model.Message;
import com.example.socialnetworkapplication.repos.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/my-app")
public class ApplicationController {

    private final MessageRepository messageRepository;

    @GetMapping("/application")
    public String getApplication(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                                 Map<String, Object> map) {
        map.put("name", name);
        return "application";
    }

    @GetMapping("/messages")
    public String main(Map<String, Object> map) {
        Iterable<Message> messages = messageRepository.findAll();
        map.put("messages", messages);
        return "main";
    }

    @PostMapping("/messages")
    public String add(@RequestParam String message, @RequestParam String tag, Map<String, Object> map) {
        Message userMessage = new Message(message, tag);
        messageRepository.save(userMessage);
        Iterable<Message> messages = messageRepository.findAll();
        map.put("messages", messages);
        return "main";
    }
}
