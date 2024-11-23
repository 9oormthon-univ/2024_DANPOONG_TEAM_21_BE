package com.jojoidu.book.easy.global.exception;

import com.jojoidu.book.easy.global.dto.ErrorReason;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GlobalCodeException extends RuntimeException {
	private BaseErrorCode errorCode;

	public ErrorReason getErrorReason() {
		return this.errorCode.getErrorReason();
	}
}
