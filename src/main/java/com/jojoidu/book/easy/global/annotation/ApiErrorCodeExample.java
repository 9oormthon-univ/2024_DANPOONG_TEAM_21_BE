package com.jojoidu.book.easy.global.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jojoidu.book.easy.global.exception.BaseErrorCode;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiErrorCodeExample {
	Class<? extends BaseErrorCode> value();
}
