package com.jojoidu.book.easy.store.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MenuDetailsResponse {

    @Schema(description = "메뉴 이름", example = "방어 사시미")
    private String menuName;

    @Schema(description = "메뉴 가격", example = "40000")
    private Integer menuPrice;

    @Schema(description = "메뉴 이미지 url", example = "https://groomiz.com/menu/1.jpg")
    private String imageUrl;

    @Schema(description = "메뉴 옵션")
    private List<OptionResponse> options;

    @Getter
    @AllArgsConstructor
    public static class OptionResponse {
        @Schema(description = "옵션 제목", example = "사이즈 옵션")
        private String optionTitle;

        @Schema(description = "옵션 상세")
        private List<OptionDetailResponse> optionDetails;
    }

    @Getter
    @AllArgsConstructor
    public static class OptionDetailResponse {
        @Schema(description = "옵션 이름", example = "대")
        private String optionName;

        @Schema(description = "옵션 가격", example = "12000")
        private Integer optionPrice;
    }
}
