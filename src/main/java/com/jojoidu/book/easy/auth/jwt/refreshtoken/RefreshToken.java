package com.jojoidu.book.easy.auth.jwt.refreshtoken;

import java.util.Date;

import com.jojoidu.book.easy.user.domain.User;



public record RefreshToken(
	String key,
	User user,
	Date expiredDate) {
}
