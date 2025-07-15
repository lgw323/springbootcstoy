package com.iamjesus.homework.global.response;

import com.iamjesus.homework.domain.Member.controller.code.MemberSuccessCode;
import jakarta.annotation.Nullable;

public record PostResponse<T> (int code, String message, @Nullable T data) {
    public static <T> PostResponse<T> of(SuccessCode successCode, T data) {
        return new PostResponse<>(successCode.getCode(), successCode.getMessage(), data);
    }
    public static <T> PostResponse<T> of(SuccessCode successCode) {
        return new PostResponse<>(successCode.getCode(), successCode.getMessage(), null);
    }
}
