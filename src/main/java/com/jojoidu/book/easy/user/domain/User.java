package com.jojoidu.book.easy.user.domain;

import org.apache.commons.validator.routines.EmailValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
	//TODO: 프로필 이미지 디폴트값 설정 필요
	@Builder
	public User(Long id, String profileImage, String userName, String email, String provider, Role role) {
		if (!EmailValidator.getInstance().isValid(email)) {
			throw new IllegalArgumentException("유효하지 않은 이메일 형식입니다.");
		}
		this.profileImage = profileImage;
		this.userName = userName;
		this.provider = provider;
		this.email = email;
		this.role = role;
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "profile_image")
	private String profileImage; //url
	@Column(name = "user_name", nullable = false)
	private String userName;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "provider", nullable = false)
	private String provider;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role;

}