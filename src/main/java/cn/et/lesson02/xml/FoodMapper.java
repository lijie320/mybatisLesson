package cn.et.lesson02.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.et.lesson02.annotion.Food;

public interface FoodMapper {
    public List queryFood(@Param("foodname") String foodname);
    
	public List queryFoodName(@Param("foodname") String foodname);
    
    public void deleteFood(String foodid);
    
    public void saveFood(Food food);
}
