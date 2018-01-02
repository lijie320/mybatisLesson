package cn.et.lesson01;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

public class test {
	
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson01/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session操作的是 指向sql语句的一个唯一标识符
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	public static void main(String[] args) throws IOException {
		SqlSession session = getSession();
		session.delete("a.deleteFood");
		//session.insert("a.insertFood");
		session.update("a.updateFood");
		List list = session.selectList("a.selectFood");
		System.out.println(list);
		session.commit();
	}
	Logger loggr = Logger.getLogger(test.class);
	@Test
	public void queryFoodname() throws IOException{
		SqlSession session = getSession();
		Map map = new HashMap();
		map.put("foodname","辣椒");
		map.put("price",20);
		List list = session.selectList("a.selectFoodName", map);
		loggr.debug(list);
		System.out.println(list);
	}
	
	@Test
	public void saveFoodname() throws IOException{
		SqlSession session = getSession();
		Map map = new HashMap();
		map.put("price",200);
		map.put("foodname","辣椒炒肉");
	    session.insert("a.insertFood", map);
	    session.commit();
	}
}
