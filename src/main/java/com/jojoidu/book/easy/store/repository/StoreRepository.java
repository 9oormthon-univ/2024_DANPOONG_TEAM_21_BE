package com.jojoidu.book.easy.store.repository;

import com.jojoidu.book.easy.store.entity.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
