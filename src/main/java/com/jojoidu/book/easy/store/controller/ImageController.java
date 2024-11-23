package com.jojoidu.book.easy.store.controller;

import com.jojoidu.book.easy.store.dto.MenuImageResponse;
import com.jojoidu.book.easy.store.dto.OptionImageResponse;
import com.jojoidu.book.easy.store.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "storeImage", description = "이미지 업로드 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/stores/uploadImage")
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/menu/{menuId}")
    @Operation(summary = "메뉴 이미지 업로드")
    public ResponseEntity<MenuImageResponse> uploadMenuImage(
            @Parameter(description = "메뉴 ID", example = "1")
            @PathVariable("menuId") Long menuId,
            @Parameter(description = "업로드할 이미지 파일")
            @RequestParam("image") MultipartFile image) {

        try {
            MenuImageResponse response = imageService.uploadMenuImage(menuId, image);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MenuImageResponse(menuId, "이미지 업로드 중 오류가 발생했습니다."));
        }
    }

    @PostMapping("/menu/{menuId}/option/{optionId}")
    @Operation(summary = "옵션 이미지 업로드")
    public ResponseEntity<OptionImageResponse> uploadOptionImage(
            @Parameter(description = "옵션 ID", example = "1")
            @PathVariable("menuId") Long menuId,
            @Parameter(description = "옵션 ID", example = "1")
            @PathVariable("optionId") Long optionId,
            @Parameter(description = "업로드할 이미지 파일")
            @RequestParam("image") MultipartFile image) {

        try {
            OptionImageResponse response = imageService.uploadOptionImage(menuId, optionId, image);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new OptionImageResponse(menuId, optionId, "이미지 업로드 중 오류가 발생했습니다."));
        }
    }
}
