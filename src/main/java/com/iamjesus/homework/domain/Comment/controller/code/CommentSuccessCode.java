package com.iamjesus.homework.domain.Comment.controller.code;

import com.iamjesus.homework.global.response.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommentSuccessCode implements SuccessCode {
    OK_REGISTERED_COMMENT(2201, "회원가입에 성공했습니다."),
    ;
    private int code;
    private String message;
}
