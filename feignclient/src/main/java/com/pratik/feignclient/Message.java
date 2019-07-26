package com.pratik.feignclient;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Message {
    private String id;
    private String title;
}
