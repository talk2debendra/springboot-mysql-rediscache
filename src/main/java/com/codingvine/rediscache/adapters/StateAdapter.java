package com.codingvine.rediscache.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.codingvine.rediscache.dto.StateDto;
import com.codingvine.rediscache.entity.State;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StateAdapter {


	public StateDto toStateDto(State state) {
		return Objects.nonNull(state) ? StateDto.builder()
				.id(state.getId())
				.code(state.getCode())
				.name(state.getName())
				.uuid(state.getUuid())
				.build() : null;
	}



	public List<StateDto> toStateDtos(List<State> states){
		return CollectionUtils.isEmpty(states) ? new ArrayList<StateDto>() :
			states.stream().map(state->toStateDto(state)).collect(Collectors.toList());
	}


	
	public State toState(StateDto stateDto) {
		return State.builder()
				.code(stateDto.getCode())
				.name(stateDto.getName())
				.build();
	}
	
	
	
}
