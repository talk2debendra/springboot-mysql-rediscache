package com.codingvine.rediscache.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingvine.rediscache.adapters.StateAdapter;
import com.codingvine.rediscache.dto.StateDto;
import com.codingvine.rediscache.service.StateService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/state")
@Log4j2
public class StateController {

	@Autowired
	private StateService stateService;


	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return ResponseEntity.ok("Working............");
	}


	@GetMapping("/list")
	public  ResponseEntity<List<StateDto>> getAllStates(){
		log.info("Request received to get all states ");
		return ResponseEntity.ok(StateAdapter.toStateDtos(stateService.getAllStates()));
	}


	@PostMapping
	public ResponseEntity<StateDto> createState(@RequestBody StateDto stateDto){
		log.info("Request received to create state for {} ",stateDto);
		return new ResponseEntity<StateDto>(StateAdapter.toStateDto(stateService.save(stateDto)),HttpStatus.CREATED);
	}



	@PutMapping
	public ResponseEntity<StateDto> updateState(@RequestBody StateDto stateDto){
		log.info("Request received to update state for {} ", stateDto);
		return new ResponseEntity<StateDto>(StateAdapter.toStateDto(stateService.update(stateDto)),HttpStatus.OK);
	}


	@DeleteMapping("/{stateId}")
	public ResponseEntity<String> deleteState(@PathVariable Long stateId){
		log.info("Request received to delete state for {} ",stateId);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	}

}
