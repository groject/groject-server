package com.example.groject.domain.user.domain;

import com.example.groject.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user")
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String school;

    @Column
    private String number;

    @Column
    private String password;

    @Column
    private String authority;

    @Builder
    public User(String name, String school, String number, String password, String authority) {
        this.name = name;
        this.school = school;
        this.number = number;
        this.password = password;
        this.authority = authority;
    }
}
