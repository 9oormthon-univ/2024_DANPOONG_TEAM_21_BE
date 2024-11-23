package com.jojoidu.book.easy.problem.entity;

import com.jojoidu.book.easy.store.entity.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id", nullable = false)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(name = "problem", nullable = false)
    private String problem;

    @OneToMany
    private List<Solution> solution;

    @OneToMany
    private List<SolutionMenu> solutionMenu;

    @Builder
    public Problem(Store store, String problem, List<Solution> solution, List<SolutionMenu> solutionMenu) {
        this.store = store;
        this.problem = problem;
        this.solution = solution;
        this.solutionMenu = solutionMenu;
    }

}
