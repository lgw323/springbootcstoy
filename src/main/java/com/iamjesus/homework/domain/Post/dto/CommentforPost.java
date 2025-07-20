package com.iamjesus.homework.domain.Post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iamjesus.homework.domain.Comment.model.Comment;

import java.time.LocalDateTime;

public record CommentforPost(Long id, Author author, String content, @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createAt) {
    public static CommentforPost from(Comment comment) {
        return new CommentforPost(comment.getId(), Author.from(comment.getMember()), comment.getContent(), comment.getCreateAt());
    }
}
