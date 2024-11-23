package com.jojoidu.book.easy.store.entity.store;

import com.jojoidu.book.easy.store.entity.menu.Menu;
import com.jojoidu.book.easy.practice.entity.Problem;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "store")
    private List<Problem> problems = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Menu> menus = new ArrayList<>();
}
