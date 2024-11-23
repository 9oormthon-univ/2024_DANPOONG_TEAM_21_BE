package com.jojoidu.book.easy.auth.provider;

import com.jojoidu.book.easy.user.domain.User;

public interface OAuthUserProvider {
	User getUser(String authorization);

	String getToken(String authorization);
}
