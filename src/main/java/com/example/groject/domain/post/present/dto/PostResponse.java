package com.example.groject.domain.post.present.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class PostResponse {
    private final List<PostDto> postDtos;

    @Getter
    @Builder
    public static class PostDto {
        private Long id;
        private String projectName;
        private String intro;
        private String skill;
        private String phoneNumber;
        private String category;
        private String imageUrl;
        private String content;
        private boolean isMine;
        private int like;

        @QueryProjection
        public PostDto(Long id, String projectName, String intro, String skill, String phoneNumber, String category, String imageUrl, String content, boolean isMine, int like) {
            this.id = id;
            this.projectName = projectName;
            this.intro = intro;
            this.skill = skill;
            this.phoneNumber = phoneNumber;
            this.category = category;
            this.imageUrl = imageUrl;
            this.content = content;
            this.isMine = isMine;
            this.like = like;
        }
    }
}
