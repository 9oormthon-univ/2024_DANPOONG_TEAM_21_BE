package com.jojoidu.book.easy.store.docs;

import com.jojoidu.book.easy.global.annotation.ExceptionDoc;
import com.jojoidu.book.easy.global.annotation.ExplainError;
import com.jojoidu.book.easy.global.exception.GlobalCodeException;
import com.jojoidu.book.easy.global.interfaces.SwaggerExampleExceptions;
import com.jojoidu.book.easy.store.exception.MenuErrorCode;
import com.jojoidu.book.easy.store.exception.MenuException;
import com.jojoidu.book.easy.store.exception.StoreErrorCode;
import com.jojoidu.book.easy.store.exception.StoreException;

@ExceptionDoc
public class MenuListExceptionDocs implements SwaggerExampleExceptions {
    @ExplainError("모드가 유효하지 않은 경우 발생합니다.")
    public GlobalCodeException 모드_유효하지_않음 = new StoreException(StoreErrorCode.INVALID_MODE);

    @ExplainError("유효하지 않은 업종 ID인 경우 발생합니다.")
    public GlobalCodeException 업종_ID_유효하지_않음 = new StoreException(StoreErrorCode.INVALID_STORE_ID);

    @ExplainError("메뉴 종류가 유효하지 않은 경우 발생합니다.")
    public GlobalCodeException 메뉴_종류_유효하지_않음 = new MenuException(MenuErrorCode.INVALID_CATEGORY);

    @ExplainError("메뉴가 없는 경우 발생합니다.")
    public GlobalCodeException 메뉴_없음 = new MenuException(MenuErrorCode.MENU_NOT_FOUND);

    @ExplainError("메뉴 ID가 유효하지 않은 경우 발생합니다.")
    public GlobalCodeException 메뉴_ID_유효하지_않음 = new MenuException(MenuErrorCode.INVALID_MENU_ID);
}
