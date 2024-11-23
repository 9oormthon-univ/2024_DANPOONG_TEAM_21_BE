package com.jojoidu.book.easy.tutorial.docs;

import com.jojoidu.book.easy.global.annotation.ExceptionDoc;
import com.jojoidu.book.easy.global.annotation.ExplainError;
import com.jojoidu.book.easy.global.exception.GlobalCodeException;
import com.jojoidu.book.easy.global.interfaces.SwaggerExampleExceptions;
import com.jojoidu.book.easy.tutorial.exception.TutorialErrorCode;
import com.jojoidu.book.easy.tutorial.exception.TutorialException;

@ExceptionDoc
public class TutorialExceptionDocs implements SwaggerExampleExceptions {

    @ExplainError("무인결제기 시범 영상이 없는 경우 발생합니다.")
    public GlobalCodeException 영상_없음 = new TutorialException(TutorialErrorCode.VIDEO_NOT_FOUND);
}
