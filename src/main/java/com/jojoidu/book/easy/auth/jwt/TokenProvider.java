package com.jojoidu.book.easy.auth.jwt;

import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

import com.jojoidu.book.easy.auth.exception.AuthErrorCode;
import com.jojoidu.book.easy.auth.exception.AuthException;
import com.jojoidu.book.easy.auth.jwt.refreshtoken.CollectionRefreshTokenRepository;
import com.jojoidu.book.easy.auth.jwt.refreshtoken.RefreshToken;
import com.jojoidu.book.easy.auth.jwt.refreshtoken.RefreshTokenRepository;
import com.jojoidu.book.easy.auth.jwt.response.TokenResponse;
import com.jojoidu.book.easy.user.domain.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenProvider {
	private final JwtProperties jwtProperties;
	private final RefreshTokenRepository refreshTokenRepository;
	private final Key key;

	public TokenProvider(
		JwtProperties jwtProperties,
		CollectionRefreshTokenRepository refreshTokenRepository
	) {
		this.jwtProperties = jwtProperties;
		this.refreshTokenRepository = refreshTokenRepository;
		byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getTokenSecret());
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}

	public TokenResponse generateTokenResponse(User user) {
		long now = (new Date().getTime());
		Date accessTokenExpiredDate = new Date(now + jwtProperties.getAccessTokenExpireTime());
		Date refreshTokenExpiredDate = new Date(now + jwtProperties.getRefreshTokenExpireTime());
		String accessToken = generateAccessToken(user, accessTokenExpiredDate);
		RefreshToken refreshToken = generateRefreshToken(user, refreshTokenExpiredDate);
		refreshTokenRepository.save(refreshToken);
		return TokenResponse.builder()
			.grantType(jwtProperties.getBearerPrefix())
			.accessToken(accessToken)
			.refreshToken(refreshToken.key())
			.accessTokenExpiredDate(accessTokenExpiredDate.getTime())
			.refreshTokenExpiredDate(refreshTokenExpiredDate.getTime())
			.memberId(user.getId())
			.build();
	}

	public String generateAccessTokenByRefreshToken(String refreshTokenKey) {
		long now = (new Date().getTime());
		RefreshToken refreshToken = refreshTokenRepository.findByKey(refreshTokenKey)
				.orElseThrow(() -> new AuthException(AuthErrorCode.INVALID_TOKEN));
		User user = refreshToken.user();
		Date accessTokenExpiredDate = new Date(now + jwtProperties.getAccessTokenExpireTime());
		return generateAccessToken(user, accessTokenExpiredDate);
	}





	public String generateAccessToken(User user, Date accessTokenExpiredDate) {
		return Jwts.builder()
			.setSubject(String.valueOf(user.getId()))
			.claim(jwtProperties.getAuthorityKey(), user.getRole().toString())
			.setExpiration(accessTokenExpiredDate)
			.signWith(key, SignatureAlgorithm.HS256)
			.compact();
	}

	private RefreshToken generateRefreshToken(User user, Date refreshTokenExpiredDate) {
		String refreshToken = Jwts.builder()
			.setExpiration(refreshTokenExpiredDate)
			.signWith(key, SignatureAlgorithm.HS256)
			.compact();
		return new RefreshToken(refreshToken, user, refreshTokenExpiredDate);
	}

}
