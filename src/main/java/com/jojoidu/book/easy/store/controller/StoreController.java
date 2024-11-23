package com.jojoidu.book.easy.store.controller;


import com.jojoidu.book.easy.global.annotation.ApiErrorExceptionsExample;
import com.jojoidu.book.easy.global.dto.ApiResponse;
import com.jojoidu.book.easy.store.docs.StoreSearchExceptionDocs;
import com.jojoidu.book.easy.store.dto.MenuDetailsResponse;
import com.jojoidu.book.easy.store.dto.MenuListResponse;
import com.jojoidu.book.easy.store.dto.StoreResponse;
import com.jojoidu.book.easy.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "store", description = "업종, 메뉴, 옵션 관련 API")
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

    @GetMapping("/{storeId}/{category}/menus")
    @Operation(summary = "설명/실습 업종 메뉴 조회", description = "설명/실습 가능한 업종의 메뉴를 조회합니다.")
    public ResponseEntity<ApiResponse<MenuListResponse>> getMenuList(
            @Parameter(description = "모드", example = "explain/practice")
            @RequestParam(name = "mode") String mode,
            @Parameter(description = "Store ID", example = "1")
            @PathVariable Long storeId,
            @Parameter(description = "Menu category", example = "시즌메뉴")
            @RequestParam String category) {


        MenuListResponse menuList = storeService.getMenuList(mode, storeId, category);
        return ResponseEntity.ok(ApiResponse.success(menuList));
    }

    @GetMapping("/{storeId}/{category}/menus/{menuId}")
    @Operation(summary = "설명/실습 업종 메뉴 상세 조회", description = "선택한 메뉴의 상세내용를 조회합니다.")
    public ResponseEntity<ApiResponse<MenuDetailsResponse>> getMenuDetails(
            @Parameter(description = "모드", example = "explain/practice")
            @RequestParam(name = "mode") String mode,
            @Parameter(description = "Menu ID", example = "1")
            @PathVariable Long menuId) {


        MenuDetailsResponse menuDetails = storeService.getMenuDetails(mode, menuId);
        return ResponseEntity.ok(ApiResponse.success(menuDetails));
    }
}
