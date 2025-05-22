package com.example.FunEnglishServer.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class UserProgressId
{
    private Long user_id;
    private Long test_id;

    public Long getUser_id() {
        return user_id;
    }

    public Long getTest_id() {
        return test_id;
    }
}