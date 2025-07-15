package com.iamjesus.homework.domain.Member.dto;

public record WithdrawRequest(String password) {
    public static WithdrawRequest of(String password) {
        return new WithdrawRequest(password);
    }
}
