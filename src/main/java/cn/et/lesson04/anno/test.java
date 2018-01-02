package cn.et.lesson04.anno;

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
	
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson04/anno/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session操作的是 指向sql语句的一个唯一标识符
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	@Test
	public void queryClassname() throws IOException{
		SqlSession session = getSession();
		ClassMapper fm = session.getMapper(ClassMapper.class);
		Class cla = new Class();
		cla.setCaddress("深圳");
		cla.setCname("张");
		List<Class> cl = fm.queryClass(cla);
		for(Class c:cl){
			System.out.println(c.getCname()+"--"+c.getCaddress());
		}
	    session.commit();
	}
	
	@Test
	public void queryClassSex() throws IOException{
		SqlSession session = getSession();
		ClassMapper fm = session.getMapper(ClassMapper.class);
		Integer sex=0;
		List<Class> cl = fm.querySex(sex);
		for(Class c:cl){
			System.out.println(c.getCname()+"--"+c.getCaddress());
		}
	    session.commit();
	}
	
	@Test
	public void queryClassGid() throws IOException{
		SqlSession session = getSession();
		ClassMapper fm = session.getMapper(ClassMapper.class);
		List<String> classList = new ArrayList<String>();
		classList.add("1");
		classList.add("2");
		classList.add("3");
		List<Class> cl = fm.queryClassGid(classList);
		for(Class c:cl){
			System.out.println(c.getCname()+"--"+c.getCaddress());
		}
	    session.commit();
	}
	
	@Test
	public void updateClass() throws IOException{
		SqlSession session = getSession();
		ClassMapper fm = session.getMapper(ClassMapper.class);
		Class cla = new Class();
		cla.setCid(1);
		cla.setCaddress("深圳南山");
		fm.updateClass(cla);
	    session.commit();
	}
}
