package com.codingvine.rediscache.service;

import java.util.List;

import com.codingvine.rediscache.dto.StateDto;
import com.codingvine.rediscache.entity.State;

public interface StateService {

	State save(StateDto stateDto);
	State update(StateDto stateDto);
	State delete(Long stateId);
	List<State> getAllStates();
}
