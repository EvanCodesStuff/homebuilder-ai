package com.example.homebuilder.controller;

import com.example.homebuilder.models.ChatRequest;
import com.example.homebuilder.models.ChatResponse;
import com.example.homebuilder.properties.HomeBuilderProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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






    @PostMapping("/api/chatbot")
    public ResponseEntity<?> chatbotEndpoint(@RequestBody ChatbotRequest request) {
        // For simplicity, let's just return the same message prefixed with "Echo: "
        String response = "Echo: " + request.getMessage();
        return ResponseEntity.ok(new ChatbotResponse(response));
    }

    // Define the request object (this should match the structure sent by your JS code)
    public static class ChatbotRequest {
        private String message;

        public ChatbotRequest() {}

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    // Define the response object (this should match the expected structure in your JS code)
    public static class ChatbotResponse {
        private String response;

        public ChatbotResponse(String response) {
            this.response = response;
        }

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }
    }
}

