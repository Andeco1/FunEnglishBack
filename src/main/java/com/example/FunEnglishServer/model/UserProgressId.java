package com.example.FunEnglishServer.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

import java.io.Serializable;

@Embeddable
public class UserProgressId implements Serializable
{
    private Long user_id;
    private Long test_id;
}