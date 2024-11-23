package com.jojoidu.book.easy.dictionary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jojoidu.book.easy.dictionary.dto.WordReqType;
import com.jojoidu.book.easy.dictionary.dto.WordTypeResDto;

import com.jojoidu.book.easy.dictionary.service.DictionaryService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Dictionary", description = "사전 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dictionary")
public class DictionaryController {

	private final DictionaryService dictionaryService;
	@GetMapping
	public WordTypeResDto getDictionary(@RequestParam WordReqType type,
		@RequestParam(required = false) String keyword) {
		return dictionaryService.getDictionary(type, keyword);
	}
}
