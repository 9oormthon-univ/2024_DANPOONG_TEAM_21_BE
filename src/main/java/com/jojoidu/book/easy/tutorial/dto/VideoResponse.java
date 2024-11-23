package com.jojoidu.book.easy.tutorial.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Schema(description = "튜토리얼 영상 응답 DTO")
@NoArgsConstructor
public class VideoResponse {

    @Schema(description = "업종 ID", example = "1")
    private Long storeId;

    @Schema(description = "업종 이름", example = "패스트푸드")
    private String storeName;

    @Schema(description = "영상 URL", example = "https://www.youtube.com/watch?v=123456")
    private String videoUrl;

    @Builder
    public VideoResponse(Long storeId, String storeName, String videoUrl) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.videoUrl = videoUrl;
    }

}
