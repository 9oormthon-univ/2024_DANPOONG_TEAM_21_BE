package com.jojoidu.book.easy.store.service;

import com.jojoidu.book.easy.store.dto.StoreResponse;
import com.jojoidu.book.easy.store.entity.PlayMode;
import com.jojoidu.book.easy.store.entity.store.Store;
import com.jojoidu.book.easy.store.exception.StoreErrorCode;
import com.jojoidu.book.easy.store.exception.StoreException;
import com.jojoidu.book.easy.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;

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
}
