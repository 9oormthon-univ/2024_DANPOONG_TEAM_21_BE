package com.jojoidu.book.easy.store.exception;

import com.jojoidu.book.easy.global.annotation.ExplainError;
import com.jojoidu.book.easy.global.dto.ErrorReason;
import com.jojoidu.book.easy.global.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.Objects;

import static com.jojoidu.book.easy.global.consts.EasyStatic.*;

@Getter
@AllArgsConstructor
public enum StoreErrorCode implements BaseErrorCode {

    INVALID_MODE(BAD_REQUEST, "USER_400_1", "잘못된 모드 요청입니다."),
    INVALID_STORE_ID(BAD_REQUEST, "USER_400_2", "유효하지 않은 업종 ID입니다."),
    STORE_NOT_FOUND(NOT_FOUND, "USER_404_1", "업종를 찾을 수 없습니다.");

    private final Integer status;
    private final String code;
    private final String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.builder().reason(reason).code(code).status(status).build();
    }

    @Override
    public String getExplainError() throws NoSuchFieldException {
        Field field = this.getClass().getField(this.name());
        ExplainError annotation = field.getAnnotation(ExplainError.class);
        return Objects.nonNull(annotation) ? annotation.value() : this.getReason();
    }
}
