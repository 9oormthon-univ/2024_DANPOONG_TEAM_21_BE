package com.jojoidu.book.easy.auth.docs;

import com.jojoidu.book.easy.auth.exception.AuthErrorCode;
import com.jojoidu.book.easy.auth.exception.AuthException;
import com.jojoidu.book.easy.global.annotation.ExceptionDoc;
import com.jojoidu.book.easy.global.annotation.ExplainError;
import com.jojoidu.book.easy.global.exception.GlobalCodeException;
import com.jojoidu.book.easy.global.interfaces.SwaggerExampleExceptions;

@ExceptionDoc
public class BasicAuthExceptionDocs implements SwaggerExampleExceptions {
	@ExplainError("엑세스 토큰이 만료된 경우 발생합니다.")
	public GlobalCodeException 토큰_만료 = new AuthException(AuthErrorCode.TOKEN_EXPIRED);
	@ExplainError("엑세스 토큰이 유효하지 않은 경우 발생합니다.")
	public GlobalCodeException 토큰_유효하지_않음 = new AuthException(AuthErrorCode.INVALID_TOKEN);
	@ExplainError("엑세스 토큰이 없는 경우 발생합니다.")
	public GlobalCodeException 토큰_없음 = new AuthException(AuthErrorCode.ACCESS_TOKEN_NOT_EXIST);
}
