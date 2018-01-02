package cn.et.lesson03.sql;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.et.lesson02.annotion.Food;

public class test {
	
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson03/sql/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session操作的是 指向sql语句的一个唯一标识符
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	@Test
	public void queryFoodname() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		
//		Map map = new HashMap();
//		map.put("foodname","辣椒炒肉");
	    List list = fm.queryFoodName("辣椒");
	    System.out.println(list);
	    session.commit();
	}
}
