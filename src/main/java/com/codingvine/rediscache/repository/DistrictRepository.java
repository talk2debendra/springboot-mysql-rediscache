package com.codingvine.rediscache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingvine.rediscache.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>{

	
}
