package com.example.projectexplainer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExplainResponse {
    private String projectOverview;
    private String keyFeatures;
    private String architecture;
    private String techStack;
    private String improvements;
    private String interviewQuestions;
}
