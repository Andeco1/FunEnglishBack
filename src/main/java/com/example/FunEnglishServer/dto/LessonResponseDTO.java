package com.example.FunEnglishServer.dto;

import lombok.Data;

@Data
public class LessonResponseDTO {
    private Long lesson_id;
    private String title;
    private String content;
    private String levelCode;
    private String levelDescription;
    
    public LessonResponseDTO(Long lesson_id, String title, String content, String levelCode, String levelDescription) {
        this.lesson_id = lesson_id;
        this.title = title;
        this.content = content;
        this.levelCode = levelCode;
        this.levelDescription = levelDescription;
    }
} 