package com.jojoidu.book.easy.auth.provider.kakao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jojoidu.book.easy.auth.jwt.JwtProperties;
import com.jojoidu.book.easy.auth.provider.OAuthUserProvider;
import com.jojoidu.book.easy.auth.provider.kakao.client.KakaoOAuthClient;
import com.jojoidu.book.easy.auth.provider.kakao.client.KakaoTokenClient;
import com.jojoidu.book.easy.auth.provider.kakao.response.KakaoOAuth2Response;
import com.jojoidu.book.easy.user.domain.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KakaoUserProvider implements OAuthUserProvider {
	private final KakaoOAuthClient kakaoClient;
	private final KakaoTokenClient kakaoTokenClient;
	private final JwtProperties jwtProperties;

	@Value("${oauth2.kakao.client-id}")
	private String clientId;

	@Value("${oauth2.kakao.client-secret}")
	private String clientSecret;

	@Value("${oauth2.kakao.redirectUri}")
	private String redirectUri;

	@Override
	public User getUser(String authorizationCode) {
		KakaoOAuth2Response response = kakaoClient.getUserInfoFromKakao(
			jwtProperties.getBearerPrefix() + authorizationCode);
		return response.toEntity();
	}

	@Override
	public String getToken(String authorizationCode) {

		ResponseEntity<String> response = kakaoTokenClient.getToken(
			"application/x-www-form-urlencoded;charset=utf-8",
			"authorization_code",
			clientId,
			redirectUri,
			authorizationCode,
			clientSecret
		);
		try {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> responseMap = mapper.readValue(response.getBody(),
				new TypeReference<Map<String, String>>() {
				});
			return responseMap.get("access_token");
		} catch (Exception err) {
			throw new RuntimeException("Failed to retrieve access token from Kakao", err);
		}
	}
}

