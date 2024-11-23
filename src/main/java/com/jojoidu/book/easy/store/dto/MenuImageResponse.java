package com.jojoidu.book.easy.store.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "메뉴 이미지 업로드 응답 DTO")
public class MenuImageResponse {

    @Schema(description = "옵션 ID", example = "101")
    private Long optionId;

    @Schema(description = "이미지 URL", example = "https://groomiz.com/classroom/1.jpg")
    private String imageUrl;
}
