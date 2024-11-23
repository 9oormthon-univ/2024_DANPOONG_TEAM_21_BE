package com.jojoidu.book.easy.dictionary.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jojoidu.book.easy.dictionary.entity.Word;
import com.jojoidu.book.easy.dictionary.entity.WordType;

public interface WordRepository extends JpaRepository<Word, Long>{

	List<Word> findByType(WordType type);


	// 전체 검색 (ALL)
	List<Word> findByWordContainingOrDescriptionContaining(String wordKeyword, String descriptionKeyword);

	// 타입과 키워드로 검색
	List<Word> findByTypeAndWordContainingOrTypeAndDescriptionContaining(
		WordType type1, String wordKeyword1,
		WordType type2, String descriptionKeyword2
	);
}
