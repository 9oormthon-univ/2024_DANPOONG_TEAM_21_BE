package com.jojoidu.book.easy.problem.entity;

import com.jojoidu.book.easy.menu.entity.Menu;
import jakarta.persistence.*;
import lombok.*;

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

    @Builder
    public SolutionMenu(Solution solution, Menu menu, Integer quantity, Integer menuTotalPrice) {
        this.solution = solution;
        this.menu = menu;
        this.quantity = quantity;
        this.menuTotalPrice = menuTotalPrice;
    }
}
