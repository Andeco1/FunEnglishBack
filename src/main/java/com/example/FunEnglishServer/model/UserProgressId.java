package com.example.FunEnglishServer.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class UserProgressId implements Serializable
{
    private Long user_id;
    private Long test_id;
}