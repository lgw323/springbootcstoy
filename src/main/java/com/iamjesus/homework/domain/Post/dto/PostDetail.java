package com.iamjesus.homework.domain.Post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record PostDetail(Long id, Author author, @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createAt, String title, String content, List<CommentforPost> comments) {
}
