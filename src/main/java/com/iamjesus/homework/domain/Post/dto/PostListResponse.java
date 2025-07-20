package com.iamjesus.homework.domain.Post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iamjesus.homework.domain.Post.model.Post;

import java.time.LocalDateTime;

public record PostListResponse(Long id, Author author, @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createAt, String title) {
    public static PostListResponse from(Post post) {
        return new PostListResponse(post.getId(), Author.from(post.getMember()), post.getCreateAt(), post.getTitle());
    }
}
