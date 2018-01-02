package cn.et.lesson02.annotion;

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

import cn.et.lesson02.annotion.FoodMapper;

public class test {
	
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson02/annotion/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session�������� ָ��sql����һ��Ψһ��ʶ��
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	@Test
	public void queryFoodname() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		
//		Map map = new HashMap();
//		map.put("foodname","��������");
	    List list = fm.queryFood("����");
	    System.out.println(list);
	    session.commit();
	}
	
	@Test
	public void deleteFood() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
	    fm.deleteFood("2");
	    session.commit();
	}
	
	@Test
	public void queryFoodName() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
	    List<Food> food = fm.queryFoodName("����");
	    System.out.println(food.toString());
	    session.commit();
	}
	
	@Test
	public void saveFood() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		Food food = new Food();
		food.setFoodname("���");
		food.setPrice("50");
	    fm.saveFood(food);
	    session.commit();
	    System.out.println(food.getFoodid());
	}
}
