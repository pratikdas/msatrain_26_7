package com.pratik.feignclientwithhystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@FeignClient(value = "MessageInquiryClient", url = "https://jsonplaceholder.typicode.com", fallback = MessageInquiryFallback.class)
public interface MessageInquiryClient {

    @GetMapping(value="/posts",consumes= MediaType.APPLICATION_JSON_VALUE)
    List<Message> getMessages();

}

@Component
class MessageInquiryFallback implements MessageInquiryClient{
    @Override
    public List<Message> getMessages() {
        List<Message> fallbackMsgs = new ArrayList<>();
        fallbackMsgs.add(new Message());
        return fallbackMsgs;
    }
}
