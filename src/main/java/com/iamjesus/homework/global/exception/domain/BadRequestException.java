package com.iamjesus.homework.global.exception.domain;

import com.iamjesus.homework.global.exception.dto.ExceptionCode;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {
    ExceptionCode code;
    public BadRequestException(ExceptionCode code) {
        super(code.getMessage());
        this.code = code;
    }
}
