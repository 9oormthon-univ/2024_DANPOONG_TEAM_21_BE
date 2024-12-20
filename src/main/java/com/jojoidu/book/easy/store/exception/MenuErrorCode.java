package com.jojoidu.book.easy.store.exception;

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
public enum MenuErrorCode implements BaseErrorCode {

    MENU_NOT_FOUND(NOT_FOUND, "MENU_404_1", "해당 Menu를 찾을 수 없습니다."),
    OPTION_NOT_FOUND(NOT_FOUND, "MENU_404_2", "해당 Option을 찾을 수 없습니다."),
    MENU_NOT_FOUND_IN_CATEGORY_OR_STORE(NOT_FOUND, "MENU_404_3", "해당 Category 또는 Store에 Menu가 존재하지 않습니다."),
    INVALID_OPTION_FOR_MENU(BAD_REQUEST, "MENU_400_1", "해당 Option은 요청된 Menu와 연관되지 않습니다."),
    INVALID_MENU_ID(BAD_REQUEST, "MENU_400_2", "유효하지 않은 Menu ID입니다."),
    INVALID_CATEGORY(BAD_REQUEST, "MENU_400_3", "유효하지 않은 Menu ID입니다."),
    INVALID_OPTION_ID(BAD_REQUEST, "MENU_400_4", "유효하지 않은 Option ID입니다."),;

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
