package com.iamjesus.homework.global.exception.domain;

import com.iamjesus.homework.global.exception.dto.ExceptionCode;
import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException {

    ExceptionCode code;

    public UnauthorizedException(ExceptionCode code) {
        super(code.getMessage());
        this.code = code;
    }
}
