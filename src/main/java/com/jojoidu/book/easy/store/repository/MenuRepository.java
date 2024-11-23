package com.jojoidu.book.easy.store.repository;

import com.jojoidu.book.easy.store.entity.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<List<Menu>> findByStoreIdAndCategory(Long storeId, String category);
    boolean existsByStoreIdAndCategory(Long storeId, String category);

}
