package com.jojoidu.book.easy.problem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solution_id", nullable = false)
    private Long solutionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    @Builder
    public Solution(Problem problem, Integer totalPrice) {
        this.problem = problem;
        this.totalPrice = totalPrice;
    }
}
