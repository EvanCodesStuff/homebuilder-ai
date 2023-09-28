package com.example.homebuilder.controller;

import com.example.homebuilder.models.ChatRequest;
import com.example.homebuilder.models.ChatResponse;
import com.example.homebuilder.properties.HomeBuilderProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChatController {

    private HomeBuilderProps homeBuilderProps;

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @GetMapping("/chat")//TODO step 3 create UI interface for chat bot
    public String chat(@RequestParam String prompt) {
        // create a request
        System.out.println(prompt);
        ChatRequest request = new ChatRequest(model, prompt,homeBuilderProps.getSystem());
        request.setN(1);

        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
    }
}
