package com.codingvine.rediscache.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingvine.rediscache.dto.DistrictDto;
import com.codingvine.rediscache.entity.District;
import com.codingvine.rediscache.service.DistrictService;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class DistrictServiceImpl implements DistrictService{
	
	@Override
	public District save(DistrictDto districtDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public District update(DistrictDto districtDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public District delete(Long districtId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<District> getAllDistricts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<District> getAllDistrictsByStateId(Long stateId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
