package com.jojoidu.book.easy.tutorial.exception;

import com.jojoidu.book.easy.global.exception.GlobalCodeException;

public class TutorialException extends GlobalCodeException {
    public TutorialException(TutorialErrorCode errorCode) {
        super(errorCode);
    }
}
