package com.example.FunEnglishServer.dto;

import lombok.Data;
import java.time.ZonedDateTime;

@Data
public class UserProgressResponseDTO {
    private Long test_id;
    private String title;
    private String levelCode;
    private Long score;
    private ZonedDateTime passedAt;
    
    public UserProgressResponseDTO(Long test_id, String title, String levelCode, Long score, ZonedDateTime passedAt) {
        this.test_id = test_id;
        this.title = title;
        this.levelCode = levelCode;
        this.score = score;
        this.passedAt = passedAt;
    }
} 