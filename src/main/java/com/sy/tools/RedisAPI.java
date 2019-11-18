package com.sy.tools;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * RedisAPI
 */
@Component
public class RedisAPI {

	@Autowired
	public StringRedisTemplate redisTemplate;

	/**
	 * 存储字符串类型数据
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(String key,String value){
		try{
			redisTemplate.opsForValue().set(key, value);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 判断key是否存在
	 * @param key
	 * @return
	 */
	public boolean exist(String key){
		try{
			return redisTemplate.hasKey(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * 读取字符串类型数据
	 * @param key
	 * @return
	 */
	public String get(String key){
		String value = null;
		try{
			value = redisTemplate.opsForValue().get(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 刷新redis缓存(方式一)
	 */
	public void flushDB(){
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

				redisConnection.flushDb();
				redisConnection.close();

				return null;
			}
		});
	}

	/**
	 * 刷新redis缓存(方式二)
	 */
	//@CacheEvict
	public void flushDB2(){

		Set<String> keys = redisTemplate.keys("*");
		redisTemplate.delete(keys);
	}
}
