package com.example.groject.domain.post.domain;

import com.example.groject.domain.user.domain.User;
import com.example.groject.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_post")
@Entity
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imageUrl;

    @Column
    private String projectName;

    @Column
    private String intro;

    @Column
    private String skill;

    @Column
    private String phoneNumber;

    @Column
    private String category;

    @Column
    private boolean isMine;

    @Column
    private int likeCheck;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;

    @Builder
    public Post(String imageUrl, String projectName, String intro, String skill, String phoneNumber, String category, User user, boolean isMine, int likeCheck) {
        this.imageUrl = imageUrl;
        this.projectName = projectName;
        this.intro = intro;
        this.skill = skill;
        this.phoneNumber = phoneNumber;
        this.category = category;
        this.user = user;
        this.isMine = isMine;
        this.likeCheck = likeCheck;
    }

    public void update(String imageUrl, String projectName, String intro, String skill, String phoneNumber, String category) {
        this.imageUrl = imageUrl;
        this.projectName = projectName;
        this.intro = intro;
        this.skill = skill;
        this.phoneNumber = phoneNumber;
        this.category = category;
    }

    public void topic(int likeCheck) {
        this.likeCheck = likeCheck;
    }
}
