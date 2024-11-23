package com.jojoidu.book.easy.store.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Schema(description = "메뉴 목록 조회 응답 DTO")
public class MenuListResponse {

    @Schema(description = "업종 ID", example = "1")
    private Long storeId;

    @Schema(description = "메뉴 종류", example = "시즌 메뉴")
    private String category;

    @Schema(description = "메뉴 목록")
    private List<MenuData> menus;

    @Getter
    @AllArgsConstructor
    public static class MenuData {

        @Schema(description = "메뉴 ID", example = "1")
        private Long menuId;

        @Schema(description = "메뉴 이름", example = "방어 사시미")
        private String menuName;

        @Schema(description = "가격", example = "40000")
        private Integer price;

        @Schema(description = "메뉴 이미지 url", example = "https://groomiz.com/menu/1.jpg")
        private String imageUrl;
    }
}