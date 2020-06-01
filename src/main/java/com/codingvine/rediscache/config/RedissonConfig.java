package com.codingvine.rediscache.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

	@Value("${redis.host}")
	private String redisHost;
	
	@Value("${redis.port}")
	private long redisport;
	
	@Bean
	public RedissonClient redissonClient() {
		
		Config config = new Config();
		config.useSingleServer()
			  .setAddress("redis://"+redisHost+":" + redisport);
		return Redisson.create(config);

	}
}
