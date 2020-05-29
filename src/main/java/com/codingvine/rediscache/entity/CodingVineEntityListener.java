package com.codingvine.rediscache.entity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Entity listener for all Entities/Models
 *
 */
public class CodingVineEntityListener {

	// This code will be executed before every insert into DB
	@PrePersist
	private void beforeInsert(AbstractJpaEntity abstractEntity) {
	}

	// This code will be executed before every update into DB
	@PreUpdate
	private void beforeUpdate(AbstractJpaEntity abstractEntity) {
	}
}