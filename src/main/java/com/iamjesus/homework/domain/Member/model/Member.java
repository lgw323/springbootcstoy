package com.iamjesus.homework.domain.Member.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    private Member(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Member of(String username, String password) {
        return new Member(username, password);
    }
}
