package com.jojoidu.book.easy.auth.docs;

import com.jojoidu.book.easy.auth.exception.AuthErrorCode;
import com.jojoidu.book.easy.auth.exception.AuthException;
import com.jojoidu.book.easy.global.annotation.ExceptionDoc;
import com.jojoidu.book.easy.global.annotation.ExplainError;
import com.jojoidu.book.easy.global.exception.GlobalCodeException;
import com.jojoidu.book.easy.global.interfaces.SwaggerExampleExceptions;

@ExceptionDoc
public class RefreshAuthExceptionDocs implements SwaggerExampleExceptions {
	@ExplainError("리프레시 토큰이 만료된 경우 발생합니다.")
	public GlobalCodeException 리프레시_토큰_만료 = new AuthException(AuthErrorCode.REFRESH_TOKEN_EXPIRED);
	@ExplainError("리프레시 토큰이 유효하지 않은 경우 발생합니다.")
	public GlobalCodeException 리프레시_토큰_유효하지_않음 = new AuthException(AuthErrorCode.INVALID_TOKEN);
}
