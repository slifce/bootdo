package com.bootdo;

import com.bootdo.common.redis.shiro.RedisManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootdoApplicationTests {

	@Autowired
	RedisManager redisManager;
	@Test
	public void contextLoads() {
		String key = "测试redis.key";
		String value = "测试redis-value";
		redisManager.set(key.getBytes(),value.getBytes());

		System.out.println(redisManager.get(key.getBytes()));

		redisManager.flushDB();
	}

}
