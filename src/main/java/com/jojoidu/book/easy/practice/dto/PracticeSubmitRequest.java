package com.jojoidu.book.easy.practice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class PracticeSubmitRequest {
    @Schema(description = "문제 ID", example = "1")
    private Long questionId;

    @Schema(description = "답변 리스트")
    private List<Answer> answers;

    @Data
    public static class Answer {
        @Schema(description = "메뉴 리스트")
        private List<Menu> menus;

        @Schema(description = "총 주문 가격", example = "37000")
        private Integer totalPrice;

        @Data
        public static class Menu {
            @Schema(description = "메뉴 이름", example = "굴탕면")
            private String menuName;

            @Schema(description = "메뉴 옵션 그룹 리스트")
            private List<OptionGroup> selectedOptions;

            @Schema(description = "메뉴 수량", example = "1")
            private Integer menuQuantity;

            @Schema(description = "메뉴 가격", example = "21000")
            private Integer menuPrice;

            @Data
            public static class OptionGroup {

                @Schema(description = "옵션 분류", example = "추가 옵션 (선택)")
                private String optionTitle;

                @Schema(description = "옵션 리스트")
                private List<Option> options;

                @Data
                public static class Option {
                    @Schema(description = "옵션 이름", example = "굴 50g")
                    private String optionName;

                    @Schema(description = "옵션 가격", example = "8000")
                    private Integer optionPrice;

                }
            }
        }
    }
}
