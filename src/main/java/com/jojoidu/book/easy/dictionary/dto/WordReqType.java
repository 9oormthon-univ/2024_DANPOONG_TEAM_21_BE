package com.jojoidu.book.easy.dictionary.dto;

import lombok.Getter;

@Getter
public enum WordReqType {
	ALL("ALL", "전체"),
	CAFE("CAFE", "카페"),
	FOOD("FOOD", "음식");

	private final String key;
	private final String title;

	WordReqType(String key, String title) {
		this.key = key;
		this.title = title;
	}
}
