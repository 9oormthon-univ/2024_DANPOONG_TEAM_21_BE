package com.jojoidu.book.easy.auth.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jojoidu.book.easy.auth.AuthProvider;
import com.jojoidu.book.easy.auth.jwt.TokenProvider;
import com.jojoidu.book.easy.auth.jwt.response.RefreshTokenResponse;
import com.jojoidu.book.easy.auth.jwt.response.TokenResponse;
import com.jojoidu.book.easy.auth.provider.OAuthUserProvider;
import com.jojoidu.book.easy.user.domain.User;
import com.jojoidu.book.easy.user.exception.UserErrorCode;
import com.jojoidu.book.easy.user.exception.UserException;
import com.jojoidu.book.easy.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
	private final Map<AuthProvider, OAuthUserProvider> authRegistrations;
	private final UserRepository userRepository;
	private final TokenProvider tokenProvider;

	@Transactional(readOnly = false)
	public TokenResponse login(AuthProvider authProvider, String accessToken) {
		User user = authRegistrations.get(authProvider).getUser(accessToken);
		User savedUser = saveOrUpdate(user);
		TokenResponse tokenResponse = tokenProvider.generateTokenResponse(savedUser);
		return tokenResponse;
	}

	@Transactional(readOnly = false)
	public TokenResponse loginWithCode(AuthProvider authProvider, String code) {
		String accessToken = getToken(authProvider, code);
		TokenResponse response = login(authProvider, accessToken);

		Optional<User> userOpt = userRepository.findById(response.getMemberId());
		if (userOpt.isEmpty())
			throw new UserException(UserErrorCode.USER_NOT_FOUND);
		return response;
	}


	private User saveOrUpdate(User user) {
		User savedMember = userRepository.findByEmailAndProvider(user.getEmail(), user.getProvider()).orElse(user);
		return userRepository.save(savedMember);
	}

	public RefreshTokenResponse generateAccessToken(String refreshToken) {
		String generatedToken = tokenProvider.generateAccessTokenByRefreshToken(refreshToken);
		return new RefreshTokenResponse(generatedToken);
	}

	public String getToken(AuthProvider authProvider, String code) {
		return authRegistrations.get(authProvider).getToken(code);
	}
}
