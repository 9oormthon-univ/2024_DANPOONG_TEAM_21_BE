package com.jojoidu.book.easy.practice.repository;

import com.jojoidu.book.easy.practice.entity.Problem;
import com.jojoidu.book.easy.practice.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
    Optional<List<Solution>> findByProblem(Problem problem);
}
