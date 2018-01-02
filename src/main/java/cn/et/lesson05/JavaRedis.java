package cn.et.lesson05;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import redis.clients.jedis.Jedis;

public class JavaRedis {
    public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.set("myname", "╫хвс");
		System.out.println(jedis.get("myname"));
	}
    
    public static byte[]objectToByte(Object obj) throws IOException{
    	ByteOutputStream bt = new ByteOutputStream();
    	ObjectOutputStream ops = new ObjectOutputStream(bt);
    	ops.writeObject(obj);
    	return bt.getBytes();
    }
    
    public static Object byteToObject(byte[] bt) throws Exception{
    	ByteInputStream bs= new ByteInputStream(bt,bt.length);
    	ObjectInputStream ops = new ObjectInputStream(bs);
    	return ops.readObject();
    }
}
