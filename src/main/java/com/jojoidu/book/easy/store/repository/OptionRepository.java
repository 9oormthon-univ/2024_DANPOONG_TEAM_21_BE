package com.jojoidu.book.easy.store.repository;

import com.jojoidu.book.easy.store.entity.menu.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

}
