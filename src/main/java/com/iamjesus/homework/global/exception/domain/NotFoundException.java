package com.iamjesus.homework.global.exception.domain;

import com.iamjesus.homework.global.exception.dto.ExceptionCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    ExceptionCode code;

    public NotFoundException(ExceptionCode code) {
        super(code.getMessage());
        this.code = code;
    }
}