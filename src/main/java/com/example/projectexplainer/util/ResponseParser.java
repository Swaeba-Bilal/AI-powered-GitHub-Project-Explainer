package com.example.projectexplainer.util;

import com.example.projectexplainer.model.ExplainResponse;

public class ResponseParser {
    public static ExplainResponse parse(String raw){
        ExplainResponse response = new ExplainResponse();
        response.setProjectOverview(extract(raw, "Project Overview"));
        response.setKeyFeatures(extract(raw, "Key Features"));
        response.setArchitecture(extract(raw, "Architecture"));
        response.setTechStack(extract(raw, "Tech Stack"));
        response.setImprovements(extract(raw, "Possible Improvements"));
        response.setInterviewQuestions(extract(raw, "Interview Questions"));

        return response;
    }
    private static String extract(String text, String section) {
        int index = text.indexOf(section);
        return index == -1 ? "" : text.substring(index);
    }
}
