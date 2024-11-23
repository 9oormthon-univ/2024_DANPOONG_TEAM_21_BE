package com.jojoidu.book.easy.tutorials.controller;

import com.jojoidu.book.easy.global.dto.ApiResponse;
import com.jojoidu.book.easy.tutorials.dto.VideoResponse;
import com.jojoidu.book.easy.tutorials.service.TutorialVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TutorialVideoController {

    private final TutorialVideoService tutorialVideoService;

    @GetMapping("/api/v1/tutorials/videos")
    public ResponseEntity<ApiResponse<List<VideoResponse>>> getVideos() {

        List<VideoResponse> videos = tutorialVideoService.getVideoResponses();
        return ResponseEntity.ok(ApiResponse.success(videos));
    }
}
