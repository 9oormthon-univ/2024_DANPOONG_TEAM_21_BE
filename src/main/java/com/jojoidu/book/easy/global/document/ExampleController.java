package com.jojoidu.book.easy.global.document;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jojoidu.book.easy.auth.exception.AuthErrorCode;
import com.jojoidu.book.easy.global.annotation.ApiErrorCodeExample;
import com.jojoidu.book.easy.global.annotation.DevelopOnlyApi;
import com.jojoidu.book.easy.global.exception.GlobalErrorCode;
import com.jojoidu.book.easy.user.exception.UserErrorCode;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/example")
@RequiredArgsConstructor
@Tag(name = "Exception Document", description = "예제 에러코드 문서화")
public class ExampleController {
	@GetMapping("/global")
	@DevelopOnlyApi
	@ApiErrorCodeExample(GlobalErrorCode.class)
	@Operation(summary = "글로벌 (aop, 서버 내부 오류등)  관련 에러 코드 나열")
	public void example() {
	}

	@GetMapping("/auth")
	@DevelopOnlyApi
	@Operation(summary = "인증 도메인 관련 에러 코드 나열")
	@ApiErrorCodeExample(AuthErrorCode.class)
	public void getAuthErrorCode() {
	}

	@GetMapping("/user")
	@DevelopOnlyApi
	@Operation(summary = "유저 도메인 관련 에러 코드 나열")
	@ApiErrorCodeExample(UserErrorCode.class)
	public void getUserErrorCode() {
	}


}
