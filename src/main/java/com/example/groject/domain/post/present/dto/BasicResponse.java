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
    private boolean isMine;
    private boolean isLiked;
    private int like;
}
