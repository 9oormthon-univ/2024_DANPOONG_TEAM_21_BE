package com.jojoidu.book.easy.tutorials.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Schema(description = "튜토리얼 영상 응답 DTO")
@NoArgsConstructor
public class VideoResponse {

    @Schema(description = "상점 ID", example = "1")
    private Long storeId;

    @Schema(description = "상점 이름", example = "바비든든")
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
