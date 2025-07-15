package com.iamjesus.homework.domain.Member.dto;

public record MemberRequest(String username, String password) {
    public static MemberRequest of(String username, String password) {
        return new MemberRequest(username, password);
    }
}
