package cn.et.lesson02.proc;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestProc {
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson02/proc/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session操作的是 指向sql语句的一个唯一标识符
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	
	@Test
	public void testProc() throws IOException{
		SqlSession session=getSession();
		Map map = new HashMap();
		map.put("p1", 1111);
		map.put("p2", 2222);
		String result = session.selectOne("proc.call_prg_add",map);
		System.out.println(map.get("result"));
	}
	
	
	@Test
	public void testProcFun() throws IOException{
		SqlSession session=getSession();
		Map map = new HashMap();
		map.put("p1", 1111);
		map.put("p2", 2222);
		String result = session.selectOne("proc.call_fun_add",map);
		System.out.println(map.get("result"));
	}
}
