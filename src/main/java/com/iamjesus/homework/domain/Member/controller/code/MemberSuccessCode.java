package com.iamjesus.homework.domain.Member.controller.code;

import com.iamjesus.homework.global.response.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements SuccessCode {
    OK_REGISTERED_MEMBER(2001, "회원가입에 성공했습니다."),
    OK_LOGGED_IN_MEMBER(2002,"로그인에 성공했습니다."),
    OK_WITHDRAWAL_MEMBER(2003, "회원탈퇴에 성공했습니다."),
    ;
    private int code;
    private String message;
}
