package com.jojoidu.book.easy.practice.exception;

import com.jojoidu.book.easy.global.exception.GlobalCodeException;

public class ProblemException extends GlobalCodeException {
    public ProblemException(ProblemErrorCode errorCode) {
        super(errorCode);
    }
}
