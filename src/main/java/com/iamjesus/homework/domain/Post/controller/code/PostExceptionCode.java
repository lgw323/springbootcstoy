package com.iamjesus.homework.domain.Post.controller.code;

import com.iamjesus.homework.global.exception.dto.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostExceptionCode implements ExceptionCode {
    BAD_REQUEST(4002, "필수 입력 정보가 없습니다."),
    NOT_FOUND_POST(4042, "존재하지 않는 게시글 id입니다."),
    UNAUTHORIZED_WRONG_ACCESS(4012, "로그인한 사용자만 게시글을 작성할 수 있습니다."),
    ;
    private int code;
    private String message;
}
