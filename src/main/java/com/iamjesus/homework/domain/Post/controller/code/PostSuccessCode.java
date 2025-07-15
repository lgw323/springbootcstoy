package com.iamjesus.homework.domain.Post.controller.code;

import com.iamjesus.homework.global.response.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostSuccessCode implements SuccessCode {
    OK_CREATED_POST(2101, "게시글 작성에 성공했습니다."),
    ;
    private int code;
    private String message;
}
