package com.jojoidu.book.easy.dictionary.dto;

import com.jojoidu.book.easy.dictionary.entity.Word;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordDto {
	@Schema(example = "1L")
	private Long word_id;
	@Schema(example = "카페라떼")
	private String word;
	@Schema(example = "커피에 우유를 탄거에요")
	private String description;


	public WordDto(Word word) {
		this.word_id = word.getId();
		this.word = word.getWord();
		this.description = word.getDescription();
	}
}
