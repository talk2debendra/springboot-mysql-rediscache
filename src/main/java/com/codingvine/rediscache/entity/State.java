package com.codingvine.rediscache.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "states")
public class State extends AbstractJpaEntity {

	
	private static final long serialVersionUID = -6628894133692913344L;


	@Column(name = "code", unique = true)
	private String code;
	
	private String name;
	
	
}
