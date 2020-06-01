package com.codingvine.rediscache.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingvine.rediscache.dto.StateDto;
import com.codingvine.rediscache.entity.State;
import com.codingvine.rediscache.repository.StateRepository;
import com.codingvine.rediscache.service.StateService;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class StateServiceImpl implements StateService{

	@Autowired
	private StateRepository stateRepository;
	
	@Override
	public State save(StateDto stateDto) {
		
		State state = stateRepository.findByCode(stateDto.getCode());
		if(Objects.nonNull(state)) {
			state = State.builder()
					.name(stateDto.getName())
					.code(state.getCode())
					.build();
			stateRepository.save(state);
		}
		return state;
	}

	@Override
	public State update(StateDto stateDto) {
		
		Optional<State> state = stateRepository.findById(stateDto.getId());
		if(state.isPresent()) {
			state.get().setName(stateDto.getName());
			state.get().setCode(stateDto.getCode());
			
			stateRepository.save(state.get());
		}
		return state.orElseThrow(() -> new EntityNotFoundException("State with Id-"+stateDto.getId() +" not found."));
	}

	@Override
	public boolean delete(Long stateId) {
		
		State state =stateRepository.findById(stateId).orElseThrow(()-> new EntityNotFoundException("State with Id-"+stateId +" not found."));
		
		stateRepository.delete(state);
		return true;
	}

	@Override
	public List<State> getAllStates() {
		return stateRepository.findAll();
	}

}
