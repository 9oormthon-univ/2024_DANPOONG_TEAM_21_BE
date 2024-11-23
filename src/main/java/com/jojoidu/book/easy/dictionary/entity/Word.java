package com.jojoidu.book.easy.dictionary.entity;

import com.jojoidu.book.easy.global.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Word extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private WordType type;

	@Column(name = "word", nullable = false)
	private String word;

	@Column(name = "description", nullable = false)
	private String description;
}
