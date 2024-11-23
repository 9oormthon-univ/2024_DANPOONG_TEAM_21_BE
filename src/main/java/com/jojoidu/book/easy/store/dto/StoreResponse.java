package com.jojoidu.book.easy.store.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "업종 목록 조회 응답 DTO")
@AllArgsConstructor
public class StoreResponse {

    @Schema(description = "업종 ID", example = "1")
    private Long id;

    @Schema(description = "업종 이름", example = "패스트푸드")
    private String name;
}
