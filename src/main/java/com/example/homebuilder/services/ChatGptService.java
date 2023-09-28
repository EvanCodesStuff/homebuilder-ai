//TODO step 4: stetch goal provide history to chat bot
//TODO step 5: OverAchiever goal Write functionality for bot to run queries

//package com.example.homebuilder.services;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class ChatGptService {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Value("${chatgpt.api.url}")
//    private String apiUrl;
//
//    @Value("${chatgpt.api.key}")
//    private String apiKey;
//
//    public String sendMessageToChatGpt(String message) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + apiKey);
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<String> requestEntity = new HttpEntity<>(message, headers);
//        System.out.println("headers: " + headers);
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
//        if (responseEntity.getStatusCode() == HttpStatus.OK) {
//            return responseEntity.getBody();
//        } else {
//            throw new RuntimeException("Error calling ChatGPT API. Status code: " + responseEntity.getStatusCodeValue());
//        }
//    }
//}