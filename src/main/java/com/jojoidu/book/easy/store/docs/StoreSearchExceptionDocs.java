package com.jojoidu.book.easy.store.docs;

import com.jojoidu.book.easy.store.exception.StoreErrorCode;
import com.jojoidu.book.easy.store.exception.StoreException;
import com.jojoidu.book.easy.global.annotation.ExceptionDoc;
import com.jojoidu.book.easy.global.annotation.ExplainError;
import com.jojoidu.book.easy.global.exception.GlobalCodeException;
import com.jojoidu.book.easy.global.interfaces.SwaggerExampleExceptions;

@ExceptionDoc
public class StoreSearchExceptionDocs implements SwaggerExampleExceptions {
    @ExplainError("모드가 유효하지 않은 경우 발생합니다.")
    public GlobalCodeException 모드_유효하지_않음 = new StoreException(StoreErrorCode.INVALID_MODE);
    @ExplainError("업종이 없는 경우 발생합니다.")
    public GlobalCodeException 업종_없음 = new StoreException(StoreErrorCode.STORE_NOT_FOUND);
}
