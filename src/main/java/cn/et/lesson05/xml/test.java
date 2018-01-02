package cn.et.lesson05.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class test {
	
	public static SqlSessionFactory getSessionFactory() throws IOException{
		String resource = "cn/et/lesson05/xml/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson05/xml/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session操作的是 指向sql语句的一个唯一标识符
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	@Test
	public void queryClassname() throws IOException{
		SqlSessionFactory session=getSessionFactory();
		SqlSession s = session.openSession();
		SqlSession s1 = session.openSession();
		ClassMapper fm = s.getMapper(ClassMapper.class);
		Class cl = fm.queryClass("2");
		s.close();
		ClassMapper fm1 = s1.getMapper(ClassMapper.class);
		Class cl1 = fm1.queryClass("2");
		System.out.println(cl.getCname()+"--"+cl.getCaddress());
	}
}
