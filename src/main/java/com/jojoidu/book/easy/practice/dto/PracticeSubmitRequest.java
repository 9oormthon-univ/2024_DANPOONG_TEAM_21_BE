package com.jojoidu.book.easy.practice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class PracticeSubmitRequest {
    @NotNull
    @Schema(description = "문제 ID", example = "1")
    @JsonProperty("question_id")
    private Long problemId;

    @Schema(description = "답변 리스트")
    private List<Answer> answers;

    @Data
    public static class Answer {
        @Schema(description = "메뉴 리스트")
        private List<Menu> menus;

        @Schema(description = "총 주문 가격", example = "37000")
        @JsonProperty("total_price")
        private Integer totalPrice;

        @Data
        public static class Menu {
            @Schema(description = "메뉴 이름", example = "굴탕면")
            @JsonProperty("menu_name")
            private String menuName;

            @Schema(description = "메뉴 옵션 그룹 리스트")
            @JsonProperty("selected_options")
            private List<OptionGroup> selectedOptions;

            @Schema(description = "메뉴 수량", example = "1")
            @JsonProperty("menu_quantity")
            private Integer menuQuantity;

            @Schema(description = "메뉴 가격", example = "21000")
            @JsonProperty("menu_price")
            private Integer menuPrice;

            @Data
            public static class OptionGroup {

                @Schema(description = "옵션 분류", example = "추가 옵션 (선택)")
                @JsonProperty("option_title")
                private String optionTitle;

                @Schema(description = "옵션 리스트")
                private List<Option> options;

                @Data
                public static class Option {
                    @Schema(description = "옵션 이름", example = "굴 50g")
                    @JsonProperty("option_name")
                    private String optionName;

                    @Schema(description = "옵션 가격", example = "8000")
                    @JsonProperty("option_price")
                    private Integer optionPrice;

                }
            }
        }
    }
}
