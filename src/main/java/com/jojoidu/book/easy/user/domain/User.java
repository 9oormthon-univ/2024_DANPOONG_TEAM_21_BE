package com.jojoidu.book.easy.user.domain;

import com.jojoidu.book.easy.practice.entity.SolveResult;
import jakarta.persistence.*;
import org.apache.commons.validator.routines.EmailValidator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
	//TODO: 프로필 이미지 디폴트값 설정 필요
	@Builder
	public User(Long id, String profileImage, String userName, String email, String provider, Role role, List<SolveResult> solveResults) {
		if (!EmailValidator.getInstance().isValid(email)) {
			throw new IllegalArgumentException("유효하지 않은 이메일 형식입니다.");
		}
		this.solveResults = solveResults;
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

	@OneToMany(mappedBy = "user")
	private List<SolveResult> solveResults = new ArrayList<>();

}
