package com.jojoidu.book.easy.practice.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.sound.midi.Soundbank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long questionId;

    @OneToMany(mappedBy = "solution", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerEntity> answers;

    @Entity
    @Data
    @NoArgsConstructor
    public static class AnswerEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "solution_id", nullable = false)
        private Solution solution;

        @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<MenuEntity> menus;

        @Column(nullable = false)
        private Integer totalPrice;

        @Entity
        @Data
        @NoArgsConstructor
        public static class MenuEntity {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            @ManyToOne
            @JoinColumn(name = "answer_id", nullable = false)
            private AnswerEntity answer;

            @Column(nullable = false)
            private String menuName;

            @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
            private List<OptionGroupEntity> selectedOptions;

            @Column(nullable = false)
            private Integer menuQuantity;

            @Column(nullable = false)
            private Integer menuPrice;

            @Entity
            @Data
            @NoArgsConstructor
            public static class OptionGroupEntity {

                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;

                @ManyToOne
                @JoinColumn(name = "menu_id", nullable = false)
                private MenuEntity menu;

                @Column(nullable = false)
                private String optionTitle;

                @OneToMany(mappedBy = "optionGroup", cascade = CascadeType.ALL, orphanRemoval = true)
                private List<OptionEntity> options;

                @Entity
                @Data
                @NoArgsConstructor
                public static class OptionEntity {

                    @Id
                    @GeneratedValue(strategy = GenerationType.IDENTITY)
                    private Long id;

                    @ManyToOne
                    @JoinColumn(name = "option_group_id", nullable = false)
                    private OptionGroupEntity optionGroup;

                    @Column(nullable = false)
                    private String optionName;

                    @Column(nullable = false)
                    private Integer optionPrice;
                }
            }
        }
    }
}