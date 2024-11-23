package com.jojoidu.book.easy.practice.entity;

import com.jojoidu.book.easy.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SolveResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // 유저와의 관계
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false) // 문제와의 관계
    private Problem problem;

    @Column(name = "menu_result", nullable = false)
    private Boolean menuResult;

    @Column(name = "option_result", nullable = false)
    private Boolean optionResult;

    @Column(name = "amount_result", nullable = false)
    private Boolean amountResult;

    @Column(name = "solved_date", nullable = false)
    private LocalDateTime solvedDate;

    @Builder
    public SolveResult(User user, Problem problem, Boolean totalResult, Boolean menuResult, Boolean optionResult, Boolean amountResult, LocalDateTime solvedDate) {
        this.user = user;
        this.problem = problem;
        this.menuResult = menuResult;
        this.optionResult = optionResult;
        this.amountResult = amountResult;
        this.solvedDate = solvedDate;
    }
}
