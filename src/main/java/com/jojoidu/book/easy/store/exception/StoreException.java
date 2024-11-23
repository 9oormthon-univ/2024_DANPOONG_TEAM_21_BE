package com.jojoidu.book.easy.store.exception;

import com.jojoidu.book.easy.global.exception.GlobalCodeException;

public class StoreException extends GlobalCodeException {
    public StoreException(StoreErrorCode errorCode) {
        super(errorCode);
    }
}
