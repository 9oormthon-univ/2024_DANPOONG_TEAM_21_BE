package com.jojoidu.book.easy.practice.repository;

import com.jojoidu.book.easy.practice.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    Optional<Problem> findByStoreId(Long storeId);

    /* 랜덤 실습 문제 출제 구현 시
    @Query(value = "SELECT * FROM problem WHERE store_id = :storeId ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Problem> findRandomByStoreId(@Param("storeId") Long storeId);
     */
}
