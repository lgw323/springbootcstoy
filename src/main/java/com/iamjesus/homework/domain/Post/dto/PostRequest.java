package com.iamjesus.homework.domain.Post.dto;

public record PostRequest(String title, String content) {
    public static PostRequest of(String title, String content) {
        return new PostRequest(title, content);
    }
}
