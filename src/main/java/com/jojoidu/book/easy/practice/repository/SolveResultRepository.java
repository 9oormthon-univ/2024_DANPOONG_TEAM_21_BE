package com.jojoidu.book.easy.practice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jojoidu.book.easy.practice.entity.SolveResult;

public interface SolveResultRepository extends JpaRepository<SolveResult, Long>{
	Optional<List<SolveResult>> findByUserId(Long userId);
}
