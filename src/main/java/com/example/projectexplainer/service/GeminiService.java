package com.example.projectexplainer.service;

import com.example.projectexplainer.config.GeminiConfig;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class GeminiService {
    private final RestTemplate restTemplate;
    private final GeminiConfig config;
    public String callGemini(String prompt){
        String url= config.getApiUrl() +"?key="+ config.getApiKey();
        Map<String, Object> requestBody = Map.of(
                "contents", java.util.List.of(
                        Map.of(
                                "parts", java.util.List.of(
                                        Map.of("text", prompt)
                                )
                        )
                )
        );

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String,Object>> request= new HttpEntity<>(requestBody,headers);
        HttpEntity<Map> response=restTemplate.postForEntity(url,request,Map.class);
        Map<String,Object> candidate=(Map<String,Object>) ((List<?>) response.getBody().get("candidates")).get(0);
        Map<String,Object> content=(Map<String,Object>) candidate.get("content");
        Map<String,Object> part= (Map<String,Object>) ((List<?>) content.get("parts")).get(0);
        return part.get("text").toString();
    }


}
