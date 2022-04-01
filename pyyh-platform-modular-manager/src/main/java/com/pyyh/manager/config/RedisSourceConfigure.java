package com.pyyh.manager.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class RedisSourceConfigure {
	@Value("${spring.redis.timeout}")
	private long redis_timeout;
	@Value("${spring.redis.nodes}")
	private String redis_nodes;
	@Value("${spring.redis.maxIdle}")
	private int redis_maxIdle;
	@Value("${spring.redis.maxActive}")
	private int redis_maxActive;
	@Value("${spring.redis.maxTotal}")
	private int redis_maxTotal;
	@Value("${spring.redis.maxWaitMillis}")
	private long redis_maxWaitMillis;
	private static JedisCluster jedisCluster;

	@Bean(name = "rediSource")
	public JedisCluster initJedisCluster() {
		String[] _nodes = redis_nodes.trim().split(",");
		HashSet<HostAndPort> nodes = new HashSet<>();
		for (String s : _nodes) {
			String[] hp = s.trim().split(":");
			nodes.add(new HostAndPort(hp[0], Integer.parseInt(hp[1])));
		}
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(redis_maxIdle);
		jedisPoolConfig.setMaxTotal(redis_maxTotal);
		jedisPoolConfig.setMaxWaitMillis(redis_maxWaitMillis);
		JedisCluster jc = new JedisCluster(nodes, jedisPoolConfig);
		RedisSourceConfigure.setJedisCluster(jc);
		return jc;
	}

	public static JedisCluster getJedisCluster() {
		return jedisCluster;
	}

	public static void setJedisCluster(JedisCluster jedisCluster) {
		RedisSourceConfigure.jedisCluster = jedisCluster;
	}
	
}
