package com.jojoidu.book.easy.store.repository;

import com.jojoidu.book.easy.store.entity.menu.Menu;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<List<Menu>> findByStoreIdAndCategory(Long storeId, String category);
    boolean existsByStoreIdAndCategory(Long storeId, String category);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END " +
            "FROM Menu m WHERE m.id = :menuId AND m.store.id = :storeId AND m.category = :category")
    boolean existsByIdAndStoreIdAndCategory(@Param("menuId") Long menuId,
                                            @Param("storeId") Long storeId,
                                            @Param("category") String category);
}
