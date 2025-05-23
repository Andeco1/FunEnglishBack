package com.example.FunEnglishServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionOptionResponse {
    private Long optionId;
    private Long questionId;
    private String optionText;
    private Boolean isCorrect;
} 