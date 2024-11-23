package com.jojoidu.book.easy.dictionary.service;

import org.springframework.stereotype.Service;

import com.jojoidu.book.easy.dictionary.dto.WordReqType;
import com.jojoidu.book.easy.dictionary.dto.WordTypeResDto;
import com.jojoidu.book.easy.dictionary.entity.WordType;
import com.jojoidu.book.easy.dictionary.repository.WordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DictionaryService {
	private final WordRepository wordRepository;

	public WordTypeResDto getDictionary(WordReqType type, String keyword) {
		WordTypeResDto dto = WordTypeResDto.builder().type(type).build();
		if (keyword == null || keyword.trim().isEmpty()) {
			keyword = ""; // 빈 키워드를 처리하여 전체 검색 동작
		}
		if (type == WordReqType.ALL) {
			dto.setByWords(wordRepository.findByWordContainingOrDescriptionContaining(keyword, keyword));
		} else {
			dto.setByWords(wordRepository.findByTypeAndKeywordInWordOrDescription(
				WordType.from(type), keyword));
		}
		return dto;
	}
}
