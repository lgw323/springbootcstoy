package com.iamjesus.homework.domain.Comment.controller.code;

import com.iamjesus.homework.global.exception.dto.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommentExceptionCode implements ExceptionCode {
    BAD_REQUEST(4001, "필수 입력 정보가 없습니다."),
    UNAUTHORIZED_WRONG_PASSWORD(4011, "로그인한 사용자만 댓글을 작성할 수 있습니다."),
    NOT_FOUND_MEMBER(4041, "존재하지 않는 회원 id입니다."),
    NOT_FOUND_POST(4042, "존재하지 않는 게시글입니다."),
    ;

    private int code;
    private String message;
}
