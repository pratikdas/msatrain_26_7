package com.pratik.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "MessageInquiryClient", url = "https://jsonplaceholder.typicode.com")
public interface MessageInquiryClient {

    @GetMapping(value="/posts",consumes= MediaType.APPLICATION_JSON_VALUE)
    List<Message> getMessages();

}
