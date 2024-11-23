package com.jojoidu.book.easy.auth.exception;

import com.jojoidu.book.easy.global.exception.GlobalCodeException;

import lombok.Getter;

@Getter
public class AuthException extends GlobalCodeException {

	public AuthException(AuthErrorCode errorCode) {
		super(errorCode);
	}
}

