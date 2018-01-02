package cn.et.lesson05.xml;

import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;

import cn.et.lesson05.JavaRedis;

import redis.clients.jedis.Jedis;

public class JavaJedis implements Cache {

	Jedis jedis = new Jedis("localhost", 6379);
	private String cacheId;
	public JavaJedis(String cacheId){
		this.cacheId = cacheId;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return cacheId;
	}

	@Override
	public Object getObject(Object key) {
		// TODO Auto-generated method stub
		//byte[] bt;
		try {
			byte[] bt = jedis.get(JavaRedis.objectToByte(key));
			if(bt==null){
				return null;
			}
			return JavaRedis.byteToObject(bt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return new ReentrantReadWriteLock();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void putObject(Object key, Object value) {
		try {
			jedis.set(JavaRedis.objectToByte(key), JavaRedis.objectToByte(value));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Object removeObject(Object key) {
		Object obj = getObject(key);
		try {
			jedis.del(JavaRedis.objectToByte(key));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
