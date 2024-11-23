package com.jojoidu.book.easy.problem.entity;

import com.jojoidu.book.easy.store.entity.menu.Menu;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SolutionMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solution_menu_id", nullable = false)
    private Long solutionMenuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solution_id", nullable = false)
    private Solution solution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "menu_total_price")
    private Integer menuTotalPrice;

    @OneToMany(mappedBy = "solutionMenu")
    private List<SolutionOption> solutionOption;

    @Builder
    public SolutionMenu(Solution solution, Menu menu, Integer quantity, Integer menuTotalPrice, List<SolutionOption> solutionOption) {
        this.solution = solution;
        this.menu = menu;
        this.quantity = quantity;
        this.menuTotalPrice = menuTotalPrice;
        this.solutionOption = solutionOption;
    }
}
