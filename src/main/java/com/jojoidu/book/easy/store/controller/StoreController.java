package com.jojoidu.book.easy.store.controller;


import com.jojoidu.book.easy.auth.docs.LoginAuthExceptionDocs;
import com.jojoidu.book.easy.global.annotation.ApiErrorExceptionsExample;
import com.jojoidu.book.easy.global.dto.ApiResponse;
import com.jojoidu.book.easy.store.docs.StoreSearchExceptionDocs;
import com.jojoidu.book.easy.store.dto.StoreResponse;
import com.jojoidu.book.easy.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "store", description = "업종 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    @Operation(summary = "설명/실습 업종 목록 조회", description = "설명/실습 가능한 업종 목록을 조회합니다.")
    @ApiErrorExceptionsExample(StoreSearchExceptionDocs.class)
    public ResponseEntity<ApiResponse<List<StoreResponse>>> getStores(
            @Parameter(description = "모드", example = "explain/practice")
            @RequestParam(name = "mode") String mode) {

        List<StoreResponse> stores = storeService.getStores(mode);
        return ResponseEntity.ok(ApiResponse.success(stores));
    }

}
