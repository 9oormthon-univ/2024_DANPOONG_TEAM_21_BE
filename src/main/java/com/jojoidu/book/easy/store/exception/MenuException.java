package com.jojoidu.book.easy.store.exception;

import com.jojoidu.book.easy.global.exception.GlobalCodeException;

public class MenuException extends GlobalCodeException {
    public MenuException(MenuErrorCode errorCode) {
        super(errorCode);
    }
}
