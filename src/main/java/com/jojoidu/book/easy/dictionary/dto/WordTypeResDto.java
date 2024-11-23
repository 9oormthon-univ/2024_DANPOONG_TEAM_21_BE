package com.jojoidu.book.easy.dictionary.dto;

import java.util.ArrayList;
import java.util.List;

import com.jojoidu.book.easy.dictionary.entity.Word;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "단어 응답")
@Builder
public class WordTypeResDto {
	@Schema(example = "ALL")
	private WordReqType type;
	@Builder.Default
	private List<WordDto> words = new ArrayList<>();

	public void setByWords(List<Word> words) {
		for (Word word : words) {
			this.words.add(new WordDto(word));
		}
	}
}
