package com.jojoidu.book.easy.dictionary.entity;

import com.jojoidu.book.easy.dictionary.dto.WordReqType;

import lombok.Getter;

@Getter
public enum WordType {
	CAFE("CAFE", "카페"),
	FOOD("FOOD", "음식");

	private final String key;
	private final String title;

	WordType(String key, String title) {
		this.key = key;
		this.title = title;
	}

	public static WordType from(WordReqType wordReqType) {
		if (wordReqType == null) {
			return null;
		}

		for (WordType wordType : WordType.values()) {
			if (wordType.getKey().equals(wordReqType.getKey())) {
				return wordType;
			}
		}

		throw new IllegalArgumentException("WordReqType에 매핑되는 WordType이 없습니다: " + wordReqType);
	}

}
