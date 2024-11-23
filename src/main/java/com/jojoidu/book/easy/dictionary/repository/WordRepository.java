package com.jojoidu.book.easy.dictionary.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jojoidu.book.easy.dictionary.entity.Word;
import com.jojoidu.book.easy.dictionary.entity.WordType;

public interface WordRepository extends JpaRepository<Word, Long>{

	List<Word> findByType(WordType type);


	// 전체 검색 (ALL)
	List<Word> findByWordContainingOrDescriptionContaining(String wordKeyword, String descriptionKeyword);

	// 타입과 키워드로 검색
	@Query("""
    SELECT w 
    FROM Word w 
    WHERE w.type = :type 
    AND (w.word LIKE %:keyword% OR w.description LIKE %:keyword%)
""")
	List<Word> findByTypeAndKeywordInWordOrDescription(
		@Param("type") WordType type,
		@Param("keyword") String keyword
	);
}
