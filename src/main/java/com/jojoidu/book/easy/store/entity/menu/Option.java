package com.jojoidu.book.easy.store.entity.menu;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @Column(name = "option_name", nullable = false)
    private String optionName;

    @Column(name = "option_price", nullable = false)
    private Integer optionPrice;

    @Column(name = "option_title", nullable = false)
    private String optionTitle;

    @Column(name = "option_image_url")
    private String imageUrl;

    @Builder
    public Option(Menu menu, String optionName, Integer optionPrice, String optionTitle, String imageUrl) {
        this.menu = menu;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
        this.optionTitle = optionTitle;
        this.imageUrl = imageUrl;
    }
}
