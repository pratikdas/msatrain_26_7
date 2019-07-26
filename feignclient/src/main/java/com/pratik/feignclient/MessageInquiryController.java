package com.pratik.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageInquiryController {

    @Autowired
    private MessageInquiryClient messageInquiryClient;

    @GetMapping("/messages")
    public List<Message> fetchMessages(){


        return messageInquiryClient.getMessages();
    }
}
