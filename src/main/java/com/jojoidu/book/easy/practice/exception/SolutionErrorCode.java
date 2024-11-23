package com.jojoidu.book.easy.practice.exception;

import com.jojoidu.book.easy.global.annotation.ExplainError;
import com.jojoidu.book.easy.global.dto.ErrorReason;
import com.jojoidu.book.easy.global.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.Objects;

import static com.jojoidu.book.easy.global.consts.EasyStatic.BAD_REQUEST;
import static com.jojoidu.book.easy.global.consts.EasyStatic.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum SolutionErrorCode implements BaseErrorCode {

    INVALID_SOLUTION_ID(BAD_REQUEST, "SOLUTION_400_1", "유효하지 않은 문제 ID입니다."),
    SOLUTION_NOT_FOUND(NOT_FOUND, "SOLUTION_404_1", "문제를 찾을 수 없습니다.");

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

