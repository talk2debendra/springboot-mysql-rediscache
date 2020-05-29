package com.codingvine.rediscache.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DistrictDto implements Serializable{

	private static final long serialVersionUID = 242342421L;
	
	private Long id;
	private String uuid;
	private String code;
	private String name;
	
	private StateDto state;
	
	
}
