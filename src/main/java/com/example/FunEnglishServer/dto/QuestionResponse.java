package com.example.FunEnglishServer.dto;

import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.model.QuestionOption;
import lombok.Data;
import java.util.List;

@Data
public class QuestionResponse {
    private Long question_id;
    private Long test_id;
    private String questionText;
    private Long points;
    private List<QuestionOption> options;

    public static QuestionResponse fromQuestion(Question question) {
        QuestionResponse response = new QuestionResponse();
        response.setQuestion_id(question.getQuestion_id());
        response.setTest_id(question.getTest().getTest_id());
        response.setQuestionText(question.getQuestionText());
        response.setPoints(question.getPoints());
        response.setOptions(question.getOptions());
        return response;
    }
} 