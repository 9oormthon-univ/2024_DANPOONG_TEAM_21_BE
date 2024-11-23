package com.jojoidu.book.easy.store.repository;

import com.jojoidu.book.easy.store.entity.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
