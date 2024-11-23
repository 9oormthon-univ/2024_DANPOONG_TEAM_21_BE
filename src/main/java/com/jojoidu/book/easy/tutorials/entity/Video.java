package com.jojoidu.book.easy.tutorials.entity;

import com.jojoidu.book.easy.problem.entity.Problem;
import com.jojoidu.book.easy.store.entity.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(name = "video_url", nullable = false)
    private String videoUrl;

    @Builder
    public Video(Store store, String videoUrl) {
        this.store = store;
        this.videoUrl = videoUrl;
    }
}
