package com.jojoidu.book.easy.store.repository;

import com.jojoidu.book.easy.store.entity.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
