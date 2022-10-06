package com.example.groject.domain.post.present.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostRequest {
    private String projectName;
    private String intro;
    private String skill;
    private String phoneNumber;
    private String category;
    private String imageUrl;
    private String content;
}