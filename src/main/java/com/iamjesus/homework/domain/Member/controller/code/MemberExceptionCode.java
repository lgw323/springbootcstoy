package com.iamjesus.homework.domain.Member.controller.code;

import com.iamjesus.homework.global.exception.dto.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberExceptionCode implements ExceptionCode {
    BAD_REQUEST(4001, "필수 입력 정보가 없습니다."),
    UNAUTHORIZED_WRONG_PASSWORD(4011, "비밀번호가 일치하지 않습니다."),
    NOT_FOUND_MEMBER(4041, "존재하지 않는 회원 id입니다."),
    ;

    private int code;
    private String message;
}
