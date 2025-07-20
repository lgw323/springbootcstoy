package com.iamjesus.homework.domain.Comment.dto;

public record CommentRequest(Long postId, String content) {
    public static CommentRequest of(Long postId, String content) { return new CommentRequest(postId, content); }
}
