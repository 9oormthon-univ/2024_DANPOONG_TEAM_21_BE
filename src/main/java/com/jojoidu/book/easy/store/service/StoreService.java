package com.jojoidu.book.easy.store.service;

import com.jojoidu.book.easy.store.dto.MenuDetailsResponse;
import com.jojoidu.book.easy.store.dto.MenuListResponse;
import com.jojoidu.book.easy.store.dto.StoreResponse;
import com.jojoidu.book.easy.store.entity.PlayMode;
import com.jojoidu.book.easy.store.entity.menu.Menu;
import com.jojoidu.book.easy.store.entity.menu.Option;
import com.jojoidu.book.easy.store.entity.store.Store;
import com.jojoidu.book.easy.store.exception.MenuErrorCode;
import com.jojoidu.book.easy.store.exception.MenuException;
import com.jojoidu.book.easy.store.exception.StoreErrorCode;
import com.jojoidu.book.easy.store.exception.StoreException;
import com.jojoidu.book.easy.store.repository.MenuRepository;
import com.jojoidu.book.easy.store.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;

    public List<StoreResponse> getStores(String mode) {
        // mode 검증
        if (!PlayMode.isValid(mode)) {
            throw new StoreException(StoreErrorCode.INVALID_MODE);
        }

        // Store 데이터 조회 후 DTO로 변환
        List<Store> stores = storeRepository.findAll();
        if (stores.isEmpty()) {
            throw new StoreException(StoreErrorCode.STORE_NOT_FOUND);
        }

        return stores.stream()
                .map(store -> new StoreResponse(store.getId(), store.getName() + " 무인결제기"))
                .collect(Collectors.toList());
    }

    public MenuListResponse getMenuList(String mode, Long storeId, String category) {
        // mode 검증
        if (!PlayMode.isValid(mode)) {
            throw new StoreException(StoreErrorCode.INVALID_MODE);
        }

        // storeId 검증
        if (storeId <= 0) {
            throw new StoreException(StoreErrorCode.INVALID_STORE_ID);
        }

        // category 검증
        boolean categoryExists = menuRepository.existsByStoreIdAndCategory(storeId, category);
        if (!categoryExists) {
            throw new MenuException(MenuErrorCode.INVALID_CATEGORY);
        }

        // 메뉴 조회
        List<Menu> menus = menuRepository.findByStoreIdAndCategory(storeId, category)
                .orElseThrow(() -> new MenuException(MenuErrorCode.MENU_NOT_FOUND));

        // 응답 데이터 생성
        return new MenuListResponse(storeId, category, menus.stream()
                .map(menu -> new MenuListResponse.MenuData(
                        menu.getId(),
                        menu.getName(),
                        menu.getPrice(),
                        menu.getImageUrl()))
                .collect(Collectors.toList()));
    }


    public MenuDetailsResponse getMenuDetails(String mode, Long menuId, Long storeId, String category) {
        // mode 검증
        if (!PlayMode.isValid(mode)) {
            throw new StoreException(StoreErrorCode.INVALID_MODE);
        }
        // menuId 검증
        if (menuId <= 0) {
            throw new StoreException(StoreErrorCode.INVALID_STORE_ID);
        }
        // menuId가 해당 storeId와 category에 존재하는지 검증
        boolean exists = menuRepository.existsByIdAndStoreIdAndCategory(menuId, storeId, category);
        if (!exists) {
            throw new MenuException(MenuErrorCode.MENU_NOT_FOUND_IN_CATEGORY_OR_STORE);
        }
        // 메뉴 조회
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new MenuException(MenuErrorCode.MENU_NOT_FOUND));

        // 옵션 그룹화: 같은 옵션 제목(optionTitle)을 기준으로 그룹핑
        Map<String, List<Option>> groupedOptions = menu.getOptions().stream()
                .collect(Collectors.groupingBy(Option::getOptionTitle));

        // DTO 변환
        List<MenuDetailsResponse.OptionResponse> options = groupedOptions.entrySet().stream()
                .map(entry -> new MenuDetailsResponse.OptionResponse(
                        entry.getKey(), // Option Title
                        entry.getValue().stream()
                                .map(option -> new MenuDetailsResponse.OptionDetailResponse(
                                        option.getOptionName(),
                                        option.getOptionPrice()
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());

        // MenuDetailResponse 생성 및 반환
        return new MenuDetailsResponse(
                menu.getName(),
                menu.getPrice(),
                menu.getImageUrl(),
                options
        );
    }
}
