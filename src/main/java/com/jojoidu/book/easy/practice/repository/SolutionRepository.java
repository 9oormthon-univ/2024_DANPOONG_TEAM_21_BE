package com.jojoidu.book.easy.practice.repository;

import com.jojoidu.book.easy.practice.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
}
