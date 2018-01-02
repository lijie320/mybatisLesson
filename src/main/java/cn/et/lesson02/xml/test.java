package cn.et.lesson02.xml;

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
		String resource = "cn/et/lesson02/xml/mybatis.xml";
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
	    List list = fm.queryFoodName("����");
	    System.out.println(list);
	    session.commit();
	}
	
	@Test
	public void deleteFood() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
	    fm.deleteFood("4");
	    session.commit();
	}
	
	@Test
	public void saveFood() throws IOException{
		SqlSession session = getSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		Food food = new Food();
		food.setFoodname("aaaa");
		food.setPrice("50");
	    fm.saveFood(food);
	    session.commit();
	    System.out.println(food.getFoodid());
	}
}
