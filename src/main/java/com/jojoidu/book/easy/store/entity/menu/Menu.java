package com.jojoidu.book.easy.store.entity.menu;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import com.jojoidu.book.easy.store.entity.store.Store;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", nullable = false)
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "menu_name", nullable = false)
    private String name;

    @Column(name = "menu_price", nullable = false)
    private Integer price;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "menu")
    private List<Option> options = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Builder
    public Menu(String category, String name, Integer price, String imageUrl, List<Option> options, Store store) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.options = options;
        this.store = store;
    }
}
