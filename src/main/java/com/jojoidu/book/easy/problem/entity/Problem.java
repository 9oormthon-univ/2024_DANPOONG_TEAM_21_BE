package com.jojoidu.book.easy.problem.entity;

import com.jojoidu.book.easy.store.entity.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id", nullable = false)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "store_id", nullable = false)
    private Store store; // Reference to the Store entity

    @Column(name = "problem", nullable = false)
    private String problem;

    @Column(name = "field")
    private String field;


}
