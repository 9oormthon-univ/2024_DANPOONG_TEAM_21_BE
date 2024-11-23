package com.jojoidu.book.easy.global.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.jojoidu.book.easy.auth.exception.AuthErrorCode;
import com.jojoidu.book.easy.auth.exception.AuthException;
import com.jojoidu.book.easy.auth.jwt.SecurityUser;


public class SecurityUtil {

	private SecurityUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static UserDetails getCurrentUserDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			return (UserDetails)authentication.getPrincipal();
		}
		throw new AuthException(AuthErrorCode.INVALID_TOKEN);
	}

	public static Long getCurrentUserId() {
		UserDetails userDetails = getCurrentUserDetails();
		if (userDetails instanceof SecurityUser) {  // Assuming SecurityUser extends UserDetails
			return ((SecurityUser)userDetails).getUserId();
		}
		throw new AuthException(AuthErrorCode.INVALID_TOKEN);
	}
}
