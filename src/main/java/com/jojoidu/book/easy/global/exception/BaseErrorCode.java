package com.jojoidu.book.easy.global.exception;

import com.jojoidu.book.easy.global.dto.ErrorReason;

public interface BaseErrorCode {
	public ErrorReason getErrorReason();

	String getExplainError() throws NoSuchFieldException;
}
