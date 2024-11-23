package com.jojoidu.book.easy.auth.docs;

import com.jojoidu.book.easy.global.annotation.ExceptionDoc;
import com.jojoidu.book.easy.global.annotation.ExplainError;
import com.jojoidu.book.easy.global.exception.GlobalCodeException;
import com.jojoidu.book.easy.global.exception.GlobalErrorCode;
import com.jojoidu.book.easy.global.exception.GlobalException;
import com.jojoidu.book.easy.global.interfaces.SwaggerExampleExceptions;

@ExceptionDoc
public class LoginAuthExceptionDocs implements SwaggerExampleExceptions {
	@ExplainError("로그인 서버에 보내는 요청에 실패한 경우 발생합니다.")
	public GlobalCodeException 서버_요청_오류 = new GlobalException(GlobalErrorCode.OTHER_SERVER_BAD_REQUEST);

	@ExplainError("카카오 서버에 보낸 토큰이 만료된 경우 발생합니다.")
	public GlobalCodeException 서버_토큰_만료 = new GlobalException(GlobalErrorCode.OTHER_SERVER_EXPIRED_TOKEN);
}
