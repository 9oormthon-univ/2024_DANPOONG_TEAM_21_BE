package com.jojoidu.book.easy.user.exception;

import com.jojoidu.book.easy.global.exception.GlobalCodeException;


public class UserException extends GlobalCodeException {
	public UserException(UserErrorCode errorCode) {
		super(errorCode);
	}
}
