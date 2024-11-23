package com.jojoidu.book.easy.practice.dto;

import java.util.List;

import com.jojoidu.book.easy.practice.entity.SolveResult;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemListResDto {
	@Schema(description = "해결한 문제 목록")
	List<ProblemResDto> problems;

	public static ProblemListResDto from(List<SolveResult> problems) {
		return new ProblemListResDto(problems.stream().map(ProblemResDto::new).toList());
	}
}
