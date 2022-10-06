package com.example.groject.domain.post.present.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class BasicResponse {
    private Long id;
    private String projectName;
    private String intro;
    private String skill;
    private String phoneNumber;
    private String category;
    private String imageUrl;
    private String content;
    private boolean isLiked;
    private boolean isMine;
    private int like;
}
