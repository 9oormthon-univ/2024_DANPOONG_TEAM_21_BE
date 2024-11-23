package com.jojoidu.book.easy.tutorial.service;

import com.jojoidu.book.easy.tutorial.dto.VideoResponse;
import com.jojoidu.book.easy.tutorial.entity.Video;
import com.jojoidu.book.easy.tutorial.exception.TutorialErrorCode;
import com.jojoidu.book.easy.tutorial.exception.TutorialException;
import com.jojoidu.book.easy.tutorial.repository.TutorialVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TutorialVideoService {

    private final TutorialVideoRepository tutorialVideoRepository;

    @Transactional(readOnly = true)
    public List<VideoResponse> getVideoResponses() {
        // 데이터베이스에서 Video 엔티티 조회
        List<Video> videos = tutorialVideoRepository.findAll();
        if (videos.isEmpty()) {
            throw new TutorialException(TutorialErrorCode.VIDEO_NOT_FOUND);
        }

        // Video 엔티티를 VideoResponse DTO로 변환
        return videos.stream()
                .map(this::convertToVideoResponse)
                .collect(Collectors.toList());
    }

    // 엔티티를 DTO로 변환하는 메서드
    private VideoResponse convertToVideoResponse(Video video) {
        String storeName = video.getStore().getName();

        return VideoResponse.builder()
                .storeId(video.getId())
                .storeName(storeName)
                .videoUrl(video.getVideoUrl())
                .build();
    }
}
