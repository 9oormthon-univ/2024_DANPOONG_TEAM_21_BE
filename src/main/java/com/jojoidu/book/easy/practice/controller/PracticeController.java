package com.jojoidu.book.easy.practice.controller;

import com.jojoidu.book.easy.global.dto.ApiResponse;
import com.jojoidu.book.easy.global.util.SecurityUtil;
import com.jojoidu.book.easy.practice.dto.PracticeSubmitRequest;
import com.jojoidu.book.easy.practice.dto.PracticeSubmitResponse;
import com.jojoidu.book.easy.practice.dto.ProblemListResDto;
import com.jojoidu.book.easy.practice.dto.ProblemResponse;
import com.jojoidu.book.easy.practice.service.PracticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Practice", description = "실습문제 출제 및 채점 api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/practice")
public class PracticeController {
    private final PracticeService practiceService;

    @Operation(summary = "Fetch problem by storeId")
    @GetMapping("/stores/{storeId}/problem")
    public ResponseEntity<ApiResponse<ProblemResponse>> getProblem(
            @Parameter(description = "Store ID", example = "1")
            @PathVariable Long storeId
    ) {
        ProblemResponse problemResponse = practiceService.getProblemByStoreId(storeId);
        return ResponseEntity.ok(ApiResponse.success(problemResponse));
    }

    @PostMapping("/{storeId}/submit")
    @Operation(summary = "실습 채점", description = "주어진 메뉴와 옵션, 수량을 기준으로 실습 채점을 수행합니다.")
    public ResponseEntity<ApiResponse<PracticeSubmitResponse>> submitPractice(
            @Parameter(description = "Store ID", example = "1") @PathVariable Long storeId,
            @RequestBody PracticeSubmitRequest request) {

        PracticeSubmitResponse response = practiceService.submitPractice(storeId, request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/completed")
    @Operation(summary = "실습 완료 목록", description = "유저의 실습 완료 기록을 받아옵니다.")
    public ResponseEntity<ApiResponse<ProblemListResDto>> getCompletedList() {
        Long userId = SecurityUtil.getCurrentUserId();
        return ResponseEntity.ok(ApiResponse.success(practiceService.getCompletedList(userId)));
    }
}
