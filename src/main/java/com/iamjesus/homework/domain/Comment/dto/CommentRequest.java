package com.iamjesus.homework.domain.Comment.dto;

public record CommentRequest(Long postid, String content) {
    public static CommentRequest of(Long postid, String content) { return new CommentRequest(postid, content); }
}
