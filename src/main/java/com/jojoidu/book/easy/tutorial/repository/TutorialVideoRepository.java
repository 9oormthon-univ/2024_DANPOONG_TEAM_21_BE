package com.jojoidu.book.easy.tutorial.repository;

import com.jojoidu.book.easy.tutorial.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialVideoRepository extends JpaRepository<Video, Long> {

}
