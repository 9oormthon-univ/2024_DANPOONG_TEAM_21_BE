package com.jojoidu.book.easy.problem.entity;

import com.jojoidu.book.easy.menu.entity.Option;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SolutionOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solution_option_id", nullable = false)
    private Long solutionOptionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solution_menu_id", nullable = false)
    private SolutionMenu solutionMenu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id", nullable = false)
    private Option option;

    @Builder
    public SolutionOption(SolutionMenu solutionMenu, Option option) {
        this.solutionMenu = solutionMenu;
        this.option = option;
    }
}
