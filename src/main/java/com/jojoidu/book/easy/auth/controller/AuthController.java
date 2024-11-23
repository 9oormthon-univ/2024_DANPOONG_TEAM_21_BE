package com.jojoidu.book.easy.auth.controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jojoidu.book.easy.auth.AuthProvider;
import com.jojoidu.book.easy.auth.docs.LoginAuthExceptionDocs;
import com.jojoidu.book.easy.auth.docs.RefreshAuthExceptionDocs;
import com.jojoidu.book.easy.auth.jwt.response.RefreshTokenResponse;
import com.jojoidu.book.easy.auth.jwt.response.TokenResponse;
import com.jojoidu.book.easy.auth.service.AuthService;
import com.jojoidu.book.easy.global.annotation.ApiErrorExceptionsExample;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Auth", description = "로그인 인증 API")
@RestController
@RequestMapping("/api/v1/login/oauth2")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;


	@PostMapping(value = "/kakao", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "카카오 로그인 인증", description = "카카오를 통한 로그인 인증을 처리합니다.")
	@ApiErrorExceptionsExample(LoginAuthExceptionDocs.class)
	public ResponseEntity<TokenResponse> loginWithKakaoCode(
		@Parameter(description = "카카오에서 받아온 AuthorizationCode", required = true, example = "카카오 Auth 서버로부터 받은 코드")
		@RequestParam String code) {
		return ResponseEntity.ok(authService.loginWithCode(AuthProvider.KAKAO, code));
	}


	@PostMapping(value = "/refresh")
	@Operation(summary = "AccessToken 갱신", description = "Refresh Token을 통해 AccessToken을 갱신합니다.")
	@ApiErrorExceptionsExample(RefreshAuthExceptionDocs.class)
	public ResponseEntity<RefreshTokenResponse> refresh(@RequestHeader("Refresh") String refreshToken) {
		return ResponseEntity.ok(authService.generateAccessToken(refreshToken));
	}

}
