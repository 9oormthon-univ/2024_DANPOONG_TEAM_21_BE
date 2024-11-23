package com.jojoidu.book.easy.store.service;

import com.jojoidu.book.easy.global.config.S3Config;
import com.jojoidu.book.easy.store.dto.MenuImageResponse;
import com.jojoidu.book.easy.store.dto.OptionImageResponse;
import com.jojoidu.book.easy.store.entity.menu.Menu;
import com.jojoidu.book.easy.store.entity.menu.Option;
import com.jojoidu.book.easy.store.exception.MenuErrorCode;
import com.jojoidu.book.easy.store.exception.MenuException;
import com.jojoidu.book.easy.store.repository.MenuRepository;
import com.jojoidu.book.easy.store.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequiredArgsConstructor
@Transactional
@Service
public class ImageService {

    private final S3Service s3Service;
    private final MenuRepository menuRepository;
    private final OptionRepository optionRepository;
    private final S3Config s3Config;

    public MenuImageResponse uploadMenuImage(Long menuId, MultipartFile imageFile) throws Exception {
        //menu 엔티티 찾기
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new MenuException(MenuErrorCode.MENU_NOT_FOUND));

        String fileName = UUID.randomUUID() + imageFile.getOriginalFilename();
        // 파일데이터와 파일명 넘겨서 S3에 저장
        String imageUrl = s3Service.uploadFile(imageFile, fileName);

        menu.setImageUrl(imageUrl);
        menuRepository.save(menu);

        return new MenuImageResponse(menu.getId(), menu.getImageUrl());
    }

    public OptionImageResponse uploadOptionImage(Long menuId, Long optionId, MultipartFile imageFile) throws Exception {
        //option 엔티티 찾기
        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new MenuException(MenuErrorCode.OPTION_NOT_FOUND));

        // menuId와 Option의 menu 관계 검증
        if (!option.getMenu().getId().equals(menuId)) {
            throw new MenuException(MenuErrorCode.INVALID_OPTION_FOR_MENU);
        }

        String fileName = UUID.randomUUID() + imageFile.getOriginalFilename();
        // 파일데이터와 파일명 넘겨서 S3에 저장
        String imageUrl = s3Service.uploadFile(imageFile, fileName);

        option.setImageUrl(imageUrl);
        optionRepository.save(option);

        return new OptionImageResponse(option.getMenu().getId(), option.getId(), option.getImageUrl());
    }
}
