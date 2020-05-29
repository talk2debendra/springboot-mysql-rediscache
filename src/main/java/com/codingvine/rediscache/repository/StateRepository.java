package com.codingvine.rediscache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingvine.rediscache.entity.State;


@Repository
public interface StateRepository extends JpaRepository<State, Long>{

}
