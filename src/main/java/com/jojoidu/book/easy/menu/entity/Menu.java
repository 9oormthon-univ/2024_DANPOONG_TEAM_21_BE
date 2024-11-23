package com.jojoidu.book.easy.menu.entity;

import com.jojoidu.book.easy.problem.entity.Solution;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", nullable = false)
    private Long id;

    @Column(name = "menu_name", nullable = false)
    private String name;

    @Column(name = "menu_price", nullable = false)
    private Integer price;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "menu")
    private List<Option> options;


    @Builder
    public Menu(String name, Integer price, String description, String imageUrl, List<Option> options) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.options = options;
    }
}
