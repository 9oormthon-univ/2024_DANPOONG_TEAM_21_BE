package com.jojoidu.book.easy.auth.provider.config;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jojoidu.book.easy.auth.AuthProvider;
import com.jojoidu.book.easy.auth.provider.OAuthUserProvider;
import com.jojoidu.book.easy.auth.provider.kakao.KakaoUserProvider;

@Configuration
public class OAuthProviderConfig {

	@Bean
	public Map<AuthProvider, OAuthUserProvider> authRegistrations(
		KakaoUserProvider kakaoUserProvider
	) {
		Map<AuthProvider, OAuthUserProvider> enumMap = new EnumMap<>(AuthProvider.class);
		enumMap.put(AuthProvider.KAKAO, kakaoUserProvider);
		return enumMap;
	}
}
