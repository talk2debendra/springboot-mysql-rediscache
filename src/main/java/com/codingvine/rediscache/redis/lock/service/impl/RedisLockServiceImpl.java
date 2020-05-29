package com.codingvine.rediscache.redis.lock.service.impl;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingvine.rediscache.redis.lock.service.RedisLockService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class RedisLockServiceImpl implements RedisLockService {

	@Autowired
	private RedissonClient redissonClient;
	
	@Override
	public RLock acquire(String lockName) {
		
		log.info("Acquiring redis Lock for ["+lockName+"]");

		return redissonClient.getLock(lockName);

	}

	@Override
	public void release(RLock rLock) {
		log.info("Releasing redis Lock for ["+rLock.getName()+"]");
		rLock.unlock();
		
	}

}
