package cn.et.lesson03.resultMap.xml;

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
		String resource = "cn/et/lesson03/resultMap/xml/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session操作的是 指向sql语句的一个唯一标识符
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	
	@Test
	public void queryGrade() throws IOException{
		SqlSession session = getSession();
		GradeMapper gm = session.getMapper(GradeMapper.class);
		List<Grade> list = gm.queryAllGrade();
		for(Grade g:list){
			System.out.println(g.getGid()+"---"+g.getGname1());
		}
		System.out.println(list.size());
	}
	
	@Test
	public void queryStudent() throws IOException{
		SqlSession session = getSession();
		StudentMapper gm = session.getMapper(StudentMapper.class);
		List<Student> list = gm.queryAllStudent();
		for(Student s:list){
			//System.out.println(s.getGid()+"---"+g);
		}
		System.out.println(list.size());
	}
	
	@Test
	public void queryManyToOne() throws IOException{
		SqlSession session = getSession();
		StudentMapper gm = session.getMapper(StudentMapper.class);
		Student student = gm.queryStudent("2");
		//System.out.println(student.getSname());
		//System.out.println(student.getSname()+"--"+student.getGrade().getGname1());
	}
	
	@Test
	public void queryOneToMany() throws IOException{
		SqlSession session = getSession();
		GradeMapper gm = session.getMapper(GradeMapper.class);
		Grade grade = gm.queryGrade("1");
		for(Student s:grade.studentList){
			System.out.println(s.getSname());
		}
		System.out.println(grade.getGname1()+"--"+grade.studentList.size());
	}
}
