package com.codingvine.rediscache.service;

import java.util.List;

import com.codingvine.rediscache.dto.DistrictDto;
import com.codingvine.rediscache.entity.District;

public interface DistrictService {

	District save(DistrictDto districtDto);
	
	District update(DistrictDto districtDto);
	
	District delete(Long districtId);
	
	
	List<District> getAllDistricts();
	
	List<District> getAllDistrictsByStateId(Long stateId);
}
