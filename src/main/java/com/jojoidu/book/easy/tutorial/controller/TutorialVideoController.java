package com.jojoidu.book.easy.tutorial.controller;

import com.jojoidu.book.easy.global.dto.ApiResponse;
import com.jojoidu.book.easy.tutorial.dto.VideoResponse;
import com.jojoidu.book.easy.tutorial.service.TutorialVideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "tutorials", description = "무인결제기 시범 영상 조회 API")
@RequiredArgsConstructor
@RestController
public class TutorialVideoController {

    private final TutorialVideoService tutorialVideoService;

    @GetMapping("/api/v1/tutorial/videos")
    @Operation(summary = "무인결제기 시범 영상 조회",  description = "등록된 업종의 무인결제기 시범 영상을  조회합니다.")
    public ResponseEntity<ApiResponse<List<VideoResponse>>> getVideos() {

        List<VideoResponse> videos = tutorialVideoService.getVideoResponses();
        return ResponseEntity.ok(ApiResponse.success(videos));
    }
}
