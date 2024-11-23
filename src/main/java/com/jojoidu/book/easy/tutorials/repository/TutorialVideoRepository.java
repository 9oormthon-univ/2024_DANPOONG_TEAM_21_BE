package com.jojoidu.book.easy.tutorials.repository;

import com.jojoidu.book.easy.tutorials.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialVideoRepository extends JpaRepository<Video, Long> {

}
