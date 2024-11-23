package com.jojoidu.book.easy.practice.exception;

import com.jojoidu.book.easy.global.exception.GlobalCodeException;

public class SolutionException extends GlobalCodeException {
    public SolutionException(SolutionErrorCode errorCode) {
        super(errorCode);
    }
}
