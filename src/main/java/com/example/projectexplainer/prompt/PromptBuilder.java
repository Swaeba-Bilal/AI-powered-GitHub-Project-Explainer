package com.example.projectexplainer.prompt;

import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {
    public String buildPrompt(String readme) {

        return """
        You are a senior software engineer and technical interviewer.

        Analyze the following GitHub project README and generate a structured explanation.

        Generate:
        1. Project Overview
        2. Key Features
        3. Architecture & Flow
        4. Tech Stack
        5. Possible Improvements
        6. 5 Interview Questions with Answers

        Rules:
        - Do NOT hallucinate features
        - Base analysis strictly on the README
        - Use professional technical language

        README:
        <<<
        %s
        >>>
        """.formatted(readme);
    }
}
