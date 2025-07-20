package com.iamjesus.homework.domain.Post.dto;

import com.iamjesus.homework.domain.Member.model.Member;

public record Author(Long id, String username) {
    public static Author from(Member member) {
        return new Author(member.getId(), member.getUsername());
    }
}
