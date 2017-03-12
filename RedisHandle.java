package com.imooc.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/*
 * 使用Jedis对redis数据库进行基本的操作
 */
public class RedisHandle {

	@Test
	public void handleRedis() {
		Jedis redis = null;
		try {
			// 使用ip与port构造Jedis对象
			redis = new Jedis("127.0.0.1", 6379);
			// 验证密码
			redis.auth("foobaredpassword");
			//set string
			redis.set("email", "loveabc@github.com");
			//set hash
			Map<String,String> map=new HashMap<String,String>();
			map.put("age", "25");
			map.put("gender", "man");
			redis.hmset("user", map);
			//set list
			redis.lpush("course", "python");
			//set set
			redis.sadd("member", "m3");
			//get all keys
			Set<String> keys=redis.keys("*");
			for(String key:keys){
			}
			//get String
			String name=redis.get("email");
			//get List
			List<String> courses=redis.lrange("course", 0, 5);
			for(String c:courses){
			}
			//get list length
			Long sum=redis.llen("course");
			//get hash
			String password=redis.hget("user", "password");
			Map<String,String> user=redis.hgetAll("user");
			Set<Entry<String,String>> allMap=user.entrySet();
			for(Entry<String,String> entry:allMap){
			}
			//get set
			Set<String> members=redis.smembers("member");
			for(String m:members){
			}
			String type=redis.type("member");
			//get type
			System.out.println(type);
		} finally {
			//关闭连接,释放资源
			if (redis != null) {
				redis.close();
			}
		}
	}

}
