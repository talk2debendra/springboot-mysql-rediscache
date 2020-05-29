package com.codingvine.rediscache.redis.lock.service;

import org.redisson.api.RLock;

public interface RedisLockService {

	RLock acquire(String lockName);

	void release(RLock rLock);
	
}
