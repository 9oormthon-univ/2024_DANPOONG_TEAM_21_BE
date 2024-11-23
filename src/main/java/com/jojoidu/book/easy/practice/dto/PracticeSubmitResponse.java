package com.jojoidu.book.easy.practice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PracticeSubmitResponse {

    @Schema(description = "문제 ID", example = "1")
    private Long problemId;

    @Schema(description = "메뉴 결과", example = "true")
    private Boolean menuResult;

    @Schema(description = "옵션 결과", example = "true")
    private Boolean optionResult;

    @Schema(description = "수량 결과", example = "true")
    private Boolean amountResult;
}

