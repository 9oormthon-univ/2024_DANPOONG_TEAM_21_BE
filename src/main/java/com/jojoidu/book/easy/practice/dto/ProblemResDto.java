package com.jojoidu.book.easy.practice.dto;

import java.time.LocalDate;

import com.jojoidu.book.easy.practice.entity.SolveResult;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProblemResDto {
	@Schema(description = "문제 ID", example = "1")
	private Long problemId;
	@Schema(description = "문제 이름", example = "문제입니다.")
	private String problem;
	@Schema(description = "문제 완료 날짜", example = "2021-08-01")
	private LocalDate solvedDate;

	public ProblemResDto(SolveResult solveResult) {
		this.problemId = solveResult.getProblem().getId();
		this.problem = solveResult.getProblem().getProblem();
		this.solvedDate = solveResult.getSolvedDate().toLocalDate();
	}

}
