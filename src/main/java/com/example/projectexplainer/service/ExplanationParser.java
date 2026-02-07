package com.example.projectexplainer.service;

import com.example.projectexplainer.model.ExplainRequest;
import com.example.projectexplainer.model.ExplainResponse;
import com.example.projectexplainer.prompt.PromptBuilder;
import com.example.projectexplainer.util.ResponseParser;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class ExplanationParser {
    private final GeminiService geminiService;
    private final PromptBuilder promptBuilder;
    public ExplainResponse explain (ExplainRequest request){
        String prompt=promptBuilder.buildPrompt(request.getReadmeContent());
        String rawResponse=geminiService.callGemini(prompt);
        return ResponseParser.parse(rawResponse);
    }
}
