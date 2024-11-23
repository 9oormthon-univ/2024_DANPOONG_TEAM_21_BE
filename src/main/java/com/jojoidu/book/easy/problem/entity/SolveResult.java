package com.jojoidu.book.easy.problem.entity;

import com.jojoidu.book.easy.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "total_result", nullable = false)
    private Boolean totalResult;

    @Column(name = "menu_result", nullable = false)
    private Boolean menuResult;

    @Column(name = "option_result", nullable = false)
    private Boolean optionResult;

    @Column(name = "amount_result", nullable = false)
    private Boolean amountResult;
}
